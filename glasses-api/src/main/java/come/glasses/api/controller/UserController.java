package come.glasses.api.controller;

import come.glasses.entity.UserEntity;
import come.glasses.entity.dto.DeleteDto;
import come.glasses.entity.dto.UserList;
import come.glasses.entity.dto.UserUpdate;
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
import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 16:42
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(value = "dts: 用户模块")
public class UserController extends BaseController {

    private final UserService userService;

    private final AuthLoginService authLoginService;

    @Autowired
    public UserController(UserService userService, AuthLoginService authLoginService) {
        this.userService = userService;
        this.authLoginService = authLoginService;
    }

    @ApiOperation(value = "根据ID获取用户", notes = "根据ID获取用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public JSONResult<UserEntity> getUser(@Valid DeleteDto deleteDto) {
        UserEntity user = currentUser();
        System.out.println(user.getName());
        UserEntity userEntity = userService.findById(deleteDto.getId());
        JSONResult<UserEntity> jsonResult = new JSONResult<>();
        if (userEntity != null) {
            jsonResult.setData(userEntity);
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setMessage("id 不存在");
        }
        return jsonResult;
    }

    @ApiOperation(value = "添加用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/add")
    public JSONResult addUser(@Valid @RequestBody UserEntity input) {
        UserEntity userEntity = authLoginService.login(input.getPhone());
        if (userEntity != null) {
            return JSONResult.error("改用户已存在");
        }
        input.setPasswordEncrypted(JwtTokenUtil.codeFromPassword(input.getPhone()));
        if (userService.updateUser(input)) {
            return JSONResult.success("添加成功", null);
        }
        return JSONResult.error("添加失败");
    }

    @ApiOperation(value = "更新用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/update")
    public JSONResult updateUser(@Valid @RequestBody UserUpdate input) {
        input.setPasswordEncrypted(JwtTokenUtil.codeFromPassword(input.getPhone()));
        if (userService.updateUserInput(input)) {
            return JSONResult.success("更新成功", null);
        }
        return JSONResult.error("更新失败");
    }

    @ApiOperation(value = "删除用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/del")
    public JSONResult delUser(@Valid @RequestBody DeleteDto input) {
        if (userService.deleteUser(input.getId())) {
            return JSONResult.success("删除成功", null);
        }
        return JSONResult.error("删除失败");
    }

    @ApiOperation(value = "全部用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/list")
    public JSONResult<List<UserEntity>> listUser(@Valid UserList input) {
        JSONResult<List<UserEntity>> jsonResult = new JSONResult<>();
        jsonResult.setData(userService.getList(input));
        jsonResult.setTotal(userService.count(input));
        return jsonResult;
    }
}
