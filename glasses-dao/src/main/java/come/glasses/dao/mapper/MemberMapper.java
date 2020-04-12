package come.glasses.dao.mapper;

import come.glasses.entity.MemberEntity;
import come.glasses.entity.dto.member.MemberInputDto;
import come.glasses.entity.dto.member.MemberList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    List<MemberList> selectList(@Param("keyword") String keyword, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    int deleteParamsKey(int id);

    int insert(MemberEntity memberEntity);

    int updateByPrimaryKey(MemberEntity memberEntity);

    MemberList selectByPrimaryKey(Integer id);

    Integer countOperationLogs(@Param("input") MemberInputDto input);
}
