package come.glasses.dao.mapper;

import come.glasses.entity.StockEntity;
import come.glasses.entity.dto.stock.StockInputDto;
import come.glasses.entity.dto.stock.StockListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockEntity record);

    int insertList(@Param("input") List<StockEntity> stockEntityList);

    StockListDto selectByPrimaryKey(Integer id);

    List<StockListDto> selectAll(@Param("input") StockInputDto input);

    int updateByPrimaryKey(StockEntity record);

    int countOperationLogs(@Param("input") StockInputDto input);
}