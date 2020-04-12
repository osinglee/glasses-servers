package come.glasses.api.controller;

import come.glasses.entity.BrandEntity;
import come.glasses.entity.dto.DeleteDto;
import come.glasses.entity.dto.brand.BrandDTO;
import come.glasses.service.BrandService;
import come.glasses.utils.BeanMapper;
import come.glasses.utils.JSONResult;
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
 * @create : 2020-04-07 16:55
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/brand")
@Api(value = "dts: 品牌管理")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ApiOperation(value = "品牌获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/list")
    public JSONResult<List<BrandEntity>> brandList() {
        List<BrandEntity> brandEntityList = brandService.brandList();
        return JSONResult.success("获取成功", brandEntityList);
    }

    @ApiOperation(value = "品牌删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/del")
    public JSONResult brandDel(@Valid @RequestBody DeleteDto input) {
        if (brandService.delKeys(input.getId())) {
            return JSONResult.success("删除成功");
        }
        return JSONResult.error("删除失败");
    }

    @ApiOperation(value = "品牌新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/insert")
    public JSONResult brandInsert(@Valid @RequestBody BrandDTO input) {
        BrandEntity brandEntity = BeanMapper.map(input, BrandEntity.class);
        if (brandService.insert(brandEntity)) {
            return JSONResult.success("新增成功");
        }
        return JSONResult.error("新增失败");
    }
}
