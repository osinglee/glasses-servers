package come.glasses.api.controller;

import come.glasses.entity.MemberEntity;
import come.glasses.entity.dto.DeleteDto;
import come.glasses.entity.dto.member.MemberInputDto;
import come.glasses.entity.dto.member.MemberList;
import come.glasses.service.MemberService;
import come.glasses.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/member")
@Api(value = "dts: 会员管理")
public class MemberController extends BaseController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation(value = "会员获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/list")
    public JSONResult<List<MemberList>> memberList(@Valid MemberInputDto input) {
        JSONResult<List<MemberList>> jsonResult = new JSONResult<>();

        List<MemberList> brandEntityList = memberService.getList(input);
        jsonResult.setData(brandEntityList);
        jsonResult.setTotal(memberService.count(input));
        return jsonResult;
    }

    @ApiOperation(value = "单个会员获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/id")
    public JSONResult<MemberList> memberId(@Valid DeleteDto input) {
        MemberList brandEntity = memberService.findById(input.getId());
        return JSONResult.success("获取成功", brandEntity);
    }

    @ApiOperation(value = "会员删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/del")
    public JSONResult memberDel(@Valid @RequestBody DeleteDto input) {
        if (memberService.deleteUser(input.getId())) {
            return JSONResult.success("删除成功");
        }
        return JSONResult.error("删除失败");
    }

    @ApiOperation(value = "会员新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/insert")
    public JSONResult memberInsert(@Valid @RequestBody MemberEntity input) {
        input.setCreateId(currentUser().getId());
        if (input.getId() != null){
            memberService.updateUserInput(input);
            return JSONResult.success("编辑成功");
        }
        if (memberService.insetUser(input)) {
            return JSONResult.success("新增成功");
        }
        return JSONResult.error("新增失败");
    }

}
