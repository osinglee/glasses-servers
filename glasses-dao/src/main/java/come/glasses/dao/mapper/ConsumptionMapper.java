package come.glasses.dao.mapper;

import come.glasses.entity.ConsumptionEntity;
import java.util.List;

public interface ConsumptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumptionEntity record);

    ConsumptionEntity selectByPrimaryKey(Integer id);

    List<ConsumptionEntity> selectAll();

    int updateByPrimaryKey(ConsumptionEntity record);
}