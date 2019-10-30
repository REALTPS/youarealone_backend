package findhuman.demo.service;

import findhuman.demo.domain.History;
import findhuman.demo.domain.HistoryRepository;
import findhuman.demo.domain.MemberRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryServiceTest {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void addNewHistory(){

    }

    @Test
    public void getHistorys(){
        List<History> historys = historyRepository.findAll();
        for(History history : historys) {
            System.out.println(history.getId());
            System.out.println(history.getName());
            System.out.println(history.getDate());
            System.out.println(history.getSerial());
            System.out.println(history.getCompany());
            System.out.println(history.getMember().getName());

            Assert.assertThat(history.getName(), is(history.getMember().getName()));

        }




    }



}