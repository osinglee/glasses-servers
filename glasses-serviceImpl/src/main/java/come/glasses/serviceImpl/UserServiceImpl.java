package come.glasses.serviceImpl;

import come.glasses.dao.mapper.UserMapper;
import come.glasses.entity.User;
import come.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUser(User input) {
        return userMapper.insert(input) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<User> getList(){
        return userMapper.selectAll();
    }
}
