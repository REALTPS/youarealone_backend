package findhuman.demo.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void create(){
        Member member = Member.builder()
                .id(4L)
                .name("mark")
                .build();
//        member.setId(5L);
//        member.setName("테스트1");

        Member newMember = memberRepository.save(member);
        Assert.assertNotNull(newMember);
    }

    @Test
    public void read(){
        Optional<Member> member = memberRepository.findById(2L);

        member.ifPresent(e -> {
            System.out.println(e.getName());
            System.out.println(e.getCreateBy());
        });

        Assert.assertNotNull(member);
    }

    @Test
    public void update(){
        Optional<Member> member = memberRepository.findById(2L);

        member.ifPresent(e -> {
            e.setName("변경");
            memberRepository.save(e);
        });

        Assert.assertNotNull(member);

    }

    @Test
    public void delete(){
        Optional<Member> member = memberRepository.findById(2L);

        member.ifPresent(e -> {
            memberRepository.delete(e);
        });

        Assert.assertNotNull(member);

    }



}