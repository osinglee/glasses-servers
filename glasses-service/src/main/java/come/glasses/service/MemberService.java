package come.glasses.service;

import come.glasses.entity.MemberEntity;
import come.glasses.entity.dto.member.MemberInputDto;
import come.glasses.entity.dto.member.MemberList;

import java.util.List;

public interface MemberService {

    MemberList findById(Integer id);

    boolean insetUser(MemberEntity memberEntity);

    boolean updateUserInput(MemberEntity memberEntity);

    boolean deleteUser(Integer id);

    List<MemberList> getList(MemberInputDto input);

    Integer count(MemberInputDto input);
}
