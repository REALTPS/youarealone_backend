package findhuman.demo.domain;

import findhuman.demo.domain.Member;
import findhuman.demo.domain.enumclass.memberStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberTest {

    @Test
    public void create(){
        Member member = new Member();
        member.setId(2L);
        member.setName("냐냐");
        member.setCreateAt(LocalDateTime.now());
        member.setCreateBy("qqq");
        member.setStatus(memberStatus.ACTIVATE);

        assertThat(member.getName(), is("냐냐"));
        assertThat(member.getCreateBy(), is("qqq"));
//        assertTrue(member.());
    }

}