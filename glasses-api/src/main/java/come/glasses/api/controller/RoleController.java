package come.glasses.api.controller;

import come.glasses.entity.RoleEntity;
import come.glasses.service.RoleService;
import come.glasses.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-10 16:38
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/role")
@Api(value = "dts: 用户模块")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "角色获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/list")
    public JSONResult<List<RoleEntity>> brandList() {
        List<RoleEntity> brandEntityList = roleService.brandList();
        return JSONResult.success("获取成功", brandEntityList);
    }
}
