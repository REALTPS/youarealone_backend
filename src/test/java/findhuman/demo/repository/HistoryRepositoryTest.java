package findhuman.demo.repository;

import findhuman.demo.model.domain.History;
import findhuman.demo.model.domain.Member;
import findhuman.demo.model.domain.enumclass.memberStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HistoryRepository historyRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void testHistoryFindAll (){

        History history = History.builder()
                .name("Hugh")
                .company("denso")
                .date(LocalDateTime.now())
                .requester("bryan")
                .serial(12345)
                .build();

    }

    @Test
    public void testAddHistory (){

        Member newMember = Member.builder()
                .name("Mark")
                .status(memberStatus.ACTIVATE)
                .createAt(LocalDateTime.now())
                .build();

        entityManager.persist(newMember);

        History history = History.builder()
                .name(newMember.getName())
                .company("denso")
                .serial(1234)
                .requester("bryan")
                .member(newMember)
                .build();

        entityManager.persist(history);

        Assert.assertEquals(history, historyRepo.findFirstByOrderByIdDesc());

    }



}
