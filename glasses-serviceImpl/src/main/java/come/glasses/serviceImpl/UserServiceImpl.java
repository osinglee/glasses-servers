package come.glasses.serviceImpl;

import come.glasses.dao.mapper.UserMapper;
import come.glasses.entity.UserEntity;
import come.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 15:46
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity findById(Integer id) {
        return new UserEntity();
    }
}
