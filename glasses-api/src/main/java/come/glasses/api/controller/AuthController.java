package come.glasses.api.controller;

import come.glasses.entity.User;
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
    public JSONResult<User> addUser(@Valid @RequestBody LoginDto input) {
        User user = authLoginService.login(input);
        if (user == null) {
            return JSONResult.error("用户名不存在");
        } else if (!JwtTokenUtil.isEqualsPassword(input.getPassword(), user.getPasswordEncrypted())) {
            return JSONResult.error("密码错误");
        } else {
            String token = JwtTokenUtil.generateToken(user.getId(), input.getPassword());
            user.setCurrentToken(token);
            user.setPasswordEncrypted("");
            return JSONResult.success("登录成功", user);
        }
    }


    @ApiOperation(value = "修改密码", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/change/pass")
    public JSONResult<User> ChangePass(@Valid @RequestBody ChangePassDto input) {
        User user = userService.findById(input.getId());
        if (user == null) {
            return JSONResult.error("用户不存在");
        } else if (!JwtTokenUtil.isEqualsPassword(input.getPass(), user.getPasswordEncrypted())) {
            return JSONResult.error("用户密码错误");
        } else {
            user.setPasswordEncrypted(JwtTokenUtil.codeFromPassword(input.getNewPass()));
            if (userService.updateUser(user)) {
                return JSONResult.success("修改成功");
            }
            return JSONResult.error("修改失败");
        }
    }


}
