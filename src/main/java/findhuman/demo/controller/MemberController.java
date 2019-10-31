package findhuman.demo.controller;

import findhuman.demo.model.dto.MemberRequestDto;
import findhuman.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import findhuman.demo.service.MemberHistoryService;

@RestController
@RequestMapping(value = "/member" , method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class MemberController {

    @Autowired
    private MemberService memberService;

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


//    @PostMapping("/member/{id}")
//    public void createMember(@PathVariable String id){
////        memberService.create();
//
//    }

}
