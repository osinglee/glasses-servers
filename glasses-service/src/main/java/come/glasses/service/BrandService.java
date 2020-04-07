package come.glasses.service;

import come.glasses.entity.BrandEntity;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 17:01
 */
public interface BrandService {

    List<BrandEntity> brandList();

    boolean delKeys(int id);

    boolean insert(BrandEntity brandEntity);
}
