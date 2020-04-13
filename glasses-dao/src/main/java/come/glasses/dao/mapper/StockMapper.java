package come.glasses.dao.mapper;

import come.glasses.entity.StockEntity;
import java.util.List;

public interface StockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockEntity record);

    StockEntity selectByPrimaryKey(Integer id);

    List<StockEntity> selectAll();

    int updateByPrimaryKey(StockEntity record);
}