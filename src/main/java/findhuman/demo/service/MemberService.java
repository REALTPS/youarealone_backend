package findhuman.demo.service;

import findhuman.demo.domain.History;
import findhuman.demo.domain.HistoryRepository;
import findhuman.demo.domain.Member;
import findhuman.demo.domain.MemberRepository;
import findhuman.demo.domain.enumclass.memberStatus;
import findhuman.demo.dto.api.MemberConverter;
import findhuman.demo.dto.MemberRequestDto;
import findhuman.demo.dto.api.MemberListConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConverter memberConverter;

    @Autowired
    private MemberListConverter memberListConverter;


    @Autowired
    private HistoryRepository historyRepository;

    public List<MemberRequestDto> getMembers(){
        return memberListConverter.convert(memberRepository.findAll());
    }

    public List<MemberRequestDto> getMembersExceptLastBuilder() {
        List<Member> members = memberRepository.findAll();

        if(members.isEmpty()){
            return null;
        }
        return search(members);
    }


    private boolean chkMember;
    private List<MemberRequestDto> search(List<Member> members) {
        Optional<History> history = Optional.ofNullable(historyRepository.findFirstByOrderByIdDesc());

        chkMember = false;
        history.ifPresent(h -> {
            members.forEach(e -> {
                if(e.equals(h.getMember())){
                    chkMember = true;
                }
            });
            if(chkMember){
                members.remove(h.getMember());
            }
        });

        return memberListConverter.convert(members);
    }

    public void addMember(String name) {
        MemberRequestDto memberRequestDto = new MemberRequestDto();
        memberRequestDto.setName(name);
        memberRequestDto.setStatus(memberStatus.ACTIVATE);
        Member member = memberRequestDto.toEntity();
        memberRepository.save(member);
    }

    public boolean deleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.map(e -> {
            memberRepository.delete(e);
            return true;
        }).orElseGet(() -> false);
    }
}
