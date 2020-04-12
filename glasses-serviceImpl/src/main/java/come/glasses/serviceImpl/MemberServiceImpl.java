package come.glasses.serviceImpl;

import come.glasses.dao.mapper.MemberMapper;
import come.glasses.entity.MemberEntity;
import come.glasses.entity.dto.member.MemberInputDto;
import come.glasses.entity.dto.member.MemberList;
import come.glasses.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    public MemberList findById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insetUser(MemberEntity memberEntity) {
        return memberMapper.insert(memberEntity) > 0;
    }

    @Override
    public boolean updateUserInput(MemberEntity memberEntity) {
        return memberMapper.updateByPrimaryKey(memberEntity) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return memberMapper.deleteParamsKey(id) > 0;
    }

    @Override
    public List<MemberList> getList(MemberInputDto input) {
        input.setOffset((input.getPage() - 1) * input.getPageSize());
        return memberMapper.selectList(input.getName(), input.getOffset(), input.getPageSize());
    }

    @Override
    public Integer count(MemberInputDto input) {
        return memberMapper.countOperationLogs(input);
    }
}
