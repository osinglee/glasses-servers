package come.glasses.serviceImpl;

import come.glasses.dao.mapper.BrandMapper;
import come.glasses.entity.BrandEntity;
import come.glasses.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 17:03
 */
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandEntity> brandList() {
        return brandMapper.selectList();
    }

    @Override
    public boolean delKeys(int id) {
        return brandMapper.deleteParamsKey(id) > 0;
    }

    @Override
    public boolean insert(BrandEntity brandEntity) {
        return brandMapper.insert(brandEntity) > 0;
    }
}
