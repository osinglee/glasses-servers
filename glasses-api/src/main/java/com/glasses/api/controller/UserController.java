package com.glasses.api.controller;

import come.glasses.entity.UserEntity;
import come.glasses.entity.dto.DeleteDto;
import come.glasses.service.UserService;
import come.glasses.utils.JSONResult;
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
@RequestMapping(value = "/user")
@Api(value = "dts: 用户模块")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "根据ID获取用户", notes = "根据ID获取用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public JSONResult<UserEntity> getUser(@Valid DeleteDto deleteDto) {
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
}
