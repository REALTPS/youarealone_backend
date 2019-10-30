package findhuman.demo.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryTest {

    @Test
    public void create(){
        History history = new History();
        history.setCompany("test");
        history.setDate(LocalDateTime.now());
        history.setId(1L);
        history.setMember(Member.builder().id(1L).name("test43").build());
        history.setRequester("dd");

        Assert.assertNotNull(history);
    }


}