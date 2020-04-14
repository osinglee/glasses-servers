package come.glasses.serviceImpl;

import come.glasses.dao.mapper.UserMapper;
import come.glasses.entity.UserEntity;
import come.glasses.entity.dto.UserList;
import come.glasses.entity.dto.UserUpdate;
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
    public UserEntity findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUser(UserEntity input) {
        return userMapper.insert(input) > 0;
    }

    @Override
    public boolean updateUserInput(UserUpdate user) {
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<UserEntity> getList(UserList input) {
        input.setOffset((input.getPage() - 1) * input.getPageSize());
        return userMapper.selectAll(input);
    }

    @Override
    public Integer count(UserList input) {
        return userMapper.countOperationLogs(input);
    }
}
