package findhuman.demo.service;

import findhuman.demo.domain.History;
import findhuman.demo.domain.HistoryRepository;
import findhuman.demo.domain.Member;
import findhuman.demo.domain.MemberRepository;
import findhuman.demo.domain.enumclass.memberStatus;
import findhuman.demo.dto.MemberRequestDto;
import org.graalvm.compiler.replacements.nodes.AssertionNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HistoryRepository historyRepository;

//    @Before
//    public void init(){
//    }


    @Test
    public void getMember() {
        Optional<Member> member = memberRepository.findById(5L);

        member.ifPresent(e-> {
            Assert.assertThat(e.getName(), is("Hugh"));
        });

        Assert.assertNotNull(member);
    }

    @Test
    public void getMembers(){
        Assert.assertNotNull(memberRepository);

        List<Member> members = memberRepository.findAll();

        for(Member member : members) {
            System.out.println("Member : " + member.getName());
        }

        Assert.assertNotNull(members);
    }

    @Test
    public void getMembersExceptLastBuilder (){

        History history = historyRepository.findFirstByOrderByIdDesc();

        List<Member> members = memberRepository.findAll();

        System.out.println("history : " + history.getMember().getName());
        System.out.println("history : " + history.getMember());

        for(Member member : members) {
            System.out.println("Member : " + member.getName());
        }

        System.out.println("-----------------------------");

        members.remove(history.getMember().getId());


        Member removeModel = null;
        for(Member member : members) {
            if ( member.getId() == history.getMember().getId()) {
                removeModel = member;
                System.out.println("Member : " + member);
            }
        }
        if(removeModel != null) {
            members.remove(removeModel);
        }

        System.out.println("===============================");
        for(Member member : members) {
                System.out.println("Member : " + member);
        }

        Assert.assertNotNull(history);
    }


    @Test
    public void addMember()
    {
        MemberRequestDto memberRequestDto = new MemberRequestDto();
//        memberRequestDto.setId(5L);
        memberRequestDto.setName("tom");
        memberRequestDto.setStatus(memberStatus.ACTIVATE);

        Member member = memberRequestDto.toEntity();
        memberRepository.save(member);

        Assert.assertThat(member.getName(), is("tom"));
        Assert.assertNotNull(member.getId());

    }

    @Test
    public void deleteMember(){
        Optional<Member> member = memberRepository.findById(20L);

        Assert.assertNotNull(member);

        member.ifPresent(e-> {
            memberRepository.delete(e);
        });

        Assert.assertNotNull(member);

    }

}