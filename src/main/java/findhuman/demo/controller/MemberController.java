package findhuman.demo.controller;

import findhuman.demo.model.dto.MemberRequestDto;
import findhuman.demo.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member" , method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping("/all")
    public List<MemberRequestDto> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/candidate")
    public List<MemberRequestDto> getMembersExceptLastBuilder() {
        return memberService.getMembersExceptLastBuilder();
    }

    @GetMapping("/add/{name}")
    public String addMember(@PathVariable String name){
        memberService.addMember(name);
        return "OK";
    }

    @DeleteMapping("/remove/{id}")
    public String deleteMember(@PathVariable Long id){
        if(memberService.deleteMember(id)){
            return "삭제 성공";
        } else {
            return "데이터 없음";
        }
    }

    @PutMapping("/update/{id}")
    public void updateMemberStatus(@PathVariable("id") Long id, @RequestBody MemberRequestDto memberRequestDto){
        memberService.updateMemberState(id, memberRequestDto);
    }

}
