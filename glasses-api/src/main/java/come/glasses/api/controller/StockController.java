package come.glasses.api.controller;

import come.glasses.entity.StockEntity;
import come.glasses.entity.dto.DeleteDto;
import come.glasses.entity.dto.stock.StockImportDto;
import come.glasses.entity.dto.stock.StockInputDto;
import come.glasses.entity.dto.stock.StockListDto;
import come.glasses.service.StockService;
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
 * @create : 2020-04-16 09:12
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/stock")
@Api(value = "dts: 库存管理")
public class StockController extends BaseController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @ApiOperation(value = "库存获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/list")
    public JSONResult<List<StockListDto>> stockList(@Valid StockInputDto input) {
        JSONResult<List<StockListDto>> jsonResult = new JSONResult<>();

        List<StockListDto> brandEntityList = stockService.getList(input);
        jsonResult.setData(brandEntityList);
        jsonResult.setTotal(stockService.count(input));
        return jsonResult;
    }

    @ApiOperation(value = "单个库存获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/id")
    public JSONResult<StockListDto> stockId(@Valid DeleteDto input) {
        StockListDto stockListDto = stockService.findById(input.getId());
        return JSONResult.success("获取成功", stockListDto);
    }

    @ApiOperation(value = "库存删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/del")
    public JSONResult stockDel(@Valid @RequestBody DeleteDto input) {
        if (stockService.deleteUser(input.getId())) {
            return JSONResult.success("删除成功");
        }
        return JSONResult.error("删除失败");
    }

    @ApiOperation(value = "库存新增/编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/insert")
    public JSONResult stockInsert(@Valid @RequestBody StockEntity input) {
        if (input.getId() != null) {
            stockService.updateUserInput(input);
            return JSONResult.success("编辑成功");
        }
        if (stockService.insetUser(input)) {
            return JSONResult.success("新增成功");
        }
        return JSONResult.error("新增失败");
    }

    @ApiOperation(value = "导入", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/import")
    public JSONResult<Integer> stockImport(@Valid @RequestBody StockImportDto input) {
        return JSONResult.success("导入成功", stockService.insetListUser(input.getData()));
    }
}
