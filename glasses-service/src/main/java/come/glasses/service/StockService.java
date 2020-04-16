package come.glasses.service;

import come.glasses.entity.StockEntity;
import come.glasses.entity.dto.stock.StockInputDto;
import come.glasses.entity.dto.stock.StockListDto;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-16 09:14
 */
public interface StockService {

    StockListDto findById(Integer id);

    boolean insetUser(StockEntity stockEntity);

    int insetListUser(List<StockEntity> stockEntityList);

    boolean updateUserInput(StockEntity stockEntity);

    boolean deleteUser(Integer id);

    List<StockListDto> getList(StockInputDto input);

    Integer count(StockInputDto input);

}
