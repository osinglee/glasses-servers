package come.glasses.service;

import come.glasses.entity.User;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 15:47
 */
public interface UserService {

    User findById(Integer id);

    boolean updateUser(User user);

    boolean deleteUser(Integer id);

    List<User> getList();

}
