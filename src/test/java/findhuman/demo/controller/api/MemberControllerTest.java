package findhuman.demo.controller.api;

import findhuman.demo.model.domain.Member;
import findhuman.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void getMembers() {
        List<Member> members = memberRepository.findAll();

        members.forEach(e-> {
            System.out.println(e.getName());
        });

    }
}