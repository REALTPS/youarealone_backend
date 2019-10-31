package findhuman.demo.model.dto.api;

import findhuman.demo.model.domain.Member;
import findhuman.demo.model.dto.MemberRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public
@Component
class MemberListConverter implements Converter<List<Member>, List<MemberRequestDto>> {

    @Override
    public List<MemberRequestDto> convert(List<Member> members) {
        List<MemberRequestDto> dtos = new ArrayList<>();
        for (Member member : members) {
            MemberRequestDto dto = new MemberRequestDto();
            dto.setId(member.getId());
            dto.setName(member.getName());
            dto.setStatus(member.getStatus());
            dtos.add(dto);
        }
        return dtos;
    }
}