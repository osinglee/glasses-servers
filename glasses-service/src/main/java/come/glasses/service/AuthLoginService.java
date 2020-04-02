package come.glasses.service;

import come.glasses.entity.User;
import come.glasses.entity.dto.LoginDto;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 11:24
 */
public interface AuthLoginService {

    User login(String phone);
}
