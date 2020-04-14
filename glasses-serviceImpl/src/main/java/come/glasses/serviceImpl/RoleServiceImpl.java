package come.glasses.serviceImpl;

import come.glasses.dao.mapper.RoleMapper;
import come.glasses.entity.RoleEntity;
import come.glasses.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-10 16:42
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleEntity> brandList() {
        return roleMapper.selectList();
    }

}
