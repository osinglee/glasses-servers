package come.glasses.serviceImpl;

import come.glasses.dao.mapper.UserMapper;
import come.glasses.entity.User;
import come.glasses.entity.dto.LoginDto;
import come.glasses.service.AuthLoginService;
import come.glasses.serviceImpl.user.AuthenticateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.plugin.liveconnect.SecurityContextHelper;

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
    public User login(String code) {
        return userMapper.selectByLoginStr(code);
    }

    /**
     * 获取token用户
     *
     * @return
     */
    public static User getCurrentAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AuthenticateServiceImpl)) {
            return null;
        }
        return ((AuthenticateServiceImpl) authentication).getPrincipal();
    }
}
