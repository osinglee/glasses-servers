package come.glasses.service;

import come.glasses.entity.User;
import come.glasses.entity.dto.UserList;
import come.glasses.entity.dto.UserUpdate;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 15:47
 */
public interface UserService {

    User findById(Integer id);

    boolean updateUser(User user);

    boolean updateUserInput(UserUpdate user);

    boolean deleteUser(Integer id);

    List<User> getList(UserList input);

    Integer count(UserList input);

}
