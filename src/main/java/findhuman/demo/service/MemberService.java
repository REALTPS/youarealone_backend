package findhuman.demo.service;

import findhuman.demo.model.domain.Member;
import findhuman.demo.model.dto.MemberRequestDto;

import java.util.List;

public interface MemberService {

    List<MemberRequestDto> getMembers();

    List<MemberRequestDto> getMembersExceptLastBuilder ();

    void addMember(String name);

    boolean deleteMember(Long id);

}
