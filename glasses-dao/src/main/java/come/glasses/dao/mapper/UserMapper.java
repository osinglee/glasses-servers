package come.glasses.dao.mapper;

import come.glasses.entity.UserEntity;
import come.glasses.entity.dto.UserList;
import come.glasses.entity.dto.UserUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    List<UserEntity> selectAll(@Param("input") UserList input);

    int updateByPrimaryKey(UserUpdate record);

    UserEntity selectByLoginStr(@Param("phone") String phone);

    Integer countOperationLogs(@Param("input") UserList input);
}