package findhuman.demo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import findhuman.demo.model.domain.Member;
import findhuman.demo.model.domain.enumclass.memberStatus;
import findhuman.demo.model.dto.MemberRequestDto;
import findhuman.demo.repository.MemberRepository;
import findhuman.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @Rollback
    public void testGetMembers () throws Exception {

        Gson gson = new Gson();

        MvcResult result = mockMvc.perform(get("/member/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        List<MemberRequestDto> memberList = gson.fromJson(content, new TypeToken<List<MemberRequestDto>>(){}.getType());

        for(MemberRequestDto member : memberList){
            System.out.println(member);
        }

    }

    @Test
    @Transactional
    @Rollback
    public void testGetMembersExceptLastBuilder() throws Exception {
        mockMvc.perform(get("/member/candidate"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Transactional
    @Rollback
    public void testAddMember () throws Exception {
        String name = "MarkTest1";

        mockMvc.perform(get("/member/add/" + name))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @MockBean
    private MemberRepository memberRepo;

    @Autowired
    private MemberService memberService;

    @Test
    public void testFindAllMembers (){
        System.out.println("testFindAllMembers");

        List<Member> expected = Arrays.asList(
            Member.builder().id(1L).name("Mark1").status(memberStatus.ACTIVATE).build(),
            Member.builder().id(1L).name("Mark2").status(memberStatus.DEACTIVATE).build()
        );

        given(memberRepo.findAll()).willReturn(expected);

        List<Member> findMemberList = memberRepo.findAll();
        assertThat(findMemberList).isEqualTo(expected);
    }

}
