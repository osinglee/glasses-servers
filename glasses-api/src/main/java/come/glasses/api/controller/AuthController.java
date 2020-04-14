package come.glasses.api.controller;

import come.glasses.entity.UserEntity;
import come.glasses.entity.dto.ChangePassDto;
import come.glasses.entity.dto.LoginDto;
import come.glasses.service.AuthLoginService;
import come.glasses.service.UserService;
import come.glasses.utils.JSONResult;
import come.glasses.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 16:42
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
@Api(value = "dts: 登录模块")
public class AuthController {
    private final AuthLoginService authLoginService;

    private final UserService userService;

    @Autowired
    public AuthController(AuthLoginService authLoginService, UserService userService) {
        this.authLoginService = authLoginService;
        this.userService = userService;
    }

    @ApiOperation(value = "登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/login")
    public JSONResult<UserEntity> addUser(@Valid @RequestBody LoginDto input) {
        UserEntity userEntity = authLoginService.login(input.getUser());
        if (userEntity == null) {
            return JSONResult.error("用户名不存在");
        } else if (!JwtTokenUtil.isEqualsPassword(input.getPassword(), userEntity.getPasswordEncrypted())) {
            return JSONResult.error("密码错误");
        } else {
            String token = JwtTokenUtil.generateToken(userEntity.getId(), input.getPassword());
            userEntity.setCurrentToken(token);
            userEntity.setPasswordEncrypted("");
            return JSONResult.success("登录成功", userEntity);
        }
    }


    @ApiOperation(value = "修改密码", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/change/pass")
    public JSONResult<UserEntity> ChangePass(@Valid @RequestBody ChangePassDto input) {
        UserEntity userEntity = userService.findById(input.getId());
        if (userEntity == null) {
            return JSONResult.error("用户不存在");
        } else if (JwtTokenUtil.isEqualsPassword(input.getNewPass(), userEntity.getPasswordEncrypted())) {
            return JSONResult.error("新密码与旧密码相同");
        } else if (!JwtTokenUtil.isEqualsPassword(input.getPass(), userEntity.getPasswordEncrypted())) {
            return JSONResult.error("用户密码错误");
        } else {
            userEntity.setPasswordEncrypted(JwtTokenUtil.codeFromPassword(input.getNewPass()));
            if (userService.updateUser(userEntity)) {
                return JSONResult.success("修改成功");
            }
            return JSONResult.error("修改失败");
        }
    }

}
