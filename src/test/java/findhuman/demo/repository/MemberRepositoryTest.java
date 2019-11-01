package findhuman.demo.repository;

import findhuman.demo.model.domain.Member;
import findhuman.demo.model.domain.enumclass.memberStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testMemberFindAll (){

        Member member1 = Member.builder().name("Mark1").status(memberStatus.ACTIVATE).createBy("pop").build();
        Member member2 = Member.builder().name("Mark2").status(memberStatus.ACTIVATE).createBy("pop").build();

        entityManager.persist(member1);
        entityManager.persist(member2);

        List<Member> findMemberList = memberRepository.findAll();

        for(Member member : findMemberList){
            System.out.println(member.toString());
        }
    }

    @Test
    public void testAddMember (){

        Member member1 = Member.builder().name("Mark1").status(memberStatus.ACTIVATE).createBy("pop").build();

        memberRepository.save(member1);

        List<Member> findMemberList = memberRepository.findAll();

        for(Member member : findMemberList){
            System.out.println(member.toString());
        }

    }

}
