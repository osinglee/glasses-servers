package come.glasses.service;

import come.glasses.entity.UserEntity;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 11:24
 */
public interface AuthLoginService {

    UserEntity login(String phone);
}
