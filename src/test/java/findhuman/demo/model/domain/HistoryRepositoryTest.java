package findhuman.demo.model.domain;

import findhuman.demo.repository.HistoryRepository;
import findhuman.demo.repository.MemberRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryRepositoryTest {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void readMembers(){
        Optional<Member> member = memberRepository.findById(3L);

        member.ifPresent(e -> {
            System.out.println(e.getName());
            System.out.println(e.getCreateBy());
        });

        Assert.assertNotNull(member);
    }

    @Test
    public void getFindFirstByOrderByIdDesc() {
        History history = historyRepository.findFirstByOrderByIdDesc();

        System.out.println("history : " + history.getId());

        Assert.assertThat(history.getId(), is(3L));

        Assert.assertNotNull(history);

////        historyRepository.find
////        History history = historyRepository.findByIdAndOrderByDateDesc();
//        History history1 = historyRepository.findByIdOrOrderByDateDesc();
//        Assert.assertNotNull(history1);
    }
//
//    @Test
//    public void getRepository(){
//        Assert.assertNotNull(historyRepository);
//    }



    @Test
    public void create(){
        Optional<Member> member = memberRepository.findById(3L);
        member.ifPresent(e -> {
            History history = History.builder()
                    .company("test")
                    .date(LocalDateTime.now())
                    .name(e.getName())
                    .member(e)
                    .requester("dd")
                    .build();
            History newHistory = historyRepository.save(history);
            Assert.assertNotNull(newHistory);
        });

        Assert.assertNotNull(member);
    }

    @Test
    public void findByOrderByIdDesc(){
        List<History> historylist = historyRepository.findByOrderByIdDesc();

        Assert.assertNotNull(historylist);


        for(History history : historylist) {
            System.out.println(history.getId());
        }


    }


}