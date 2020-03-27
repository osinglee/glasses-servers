package come.glasses.dao.mapper;

import come.glasses.entity.User;
import come.glasses.entity.dto.UserList;
import come.glasses.entity.dto.UserUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll(@Param("input") UserList input);

    int updateByPrimaryKey(UserUpdate record);

    User selectByLoginStr(@Param("code") String code);

    Integer countOperationLogs(UserList record);
}