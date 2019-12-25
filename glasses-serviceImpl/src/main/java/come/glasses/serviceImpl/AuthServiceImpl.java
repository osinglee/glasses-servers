package come.glasses.serviceImpl;

import come.glasses.dao.mapper.UserMapper;
import come.glasses.entity.User;
import come.glasses.entity.dto.LoginDto;
import come.glasses.service.AuthLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 15:46
 */
@Service
public class AuthServiceImpl implements AuthLoginService {

    private final UserMapper userMapper;

    @Autowired
    public AuthServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(LoginDto input) {
        return userMapper.selectByLoginStr(input.getUser());
    }
}
