package come.glasses.dao.mapper;

import come.glasses.entity.BrandEntity;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 17:07
 */
public interface BrandMapper {

    List<BrandEntity> selectList();

    int deleteParamsKey(int id);

    int insert(BrandEntity brandEntity);
}
