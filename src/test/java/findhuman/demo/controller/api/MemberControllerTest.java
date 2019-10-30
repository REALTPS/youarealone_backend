package findhuman.demo.controller.api;

import findhuman.demo.domain.Member;
import findhuman.demo.domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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