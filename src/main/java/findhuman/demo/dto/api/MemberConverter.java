package findhuman.demo.dto.api;

import findhuman.demo.domain.Member;
import findhuman.demo.dto.MemberRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class MemberConverter implements Converter<Member , MemberRequestDto> {

        @Override
        public MemberRequestDto convert(Member member) {
            return MemberRequestDto.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .status(member.getStatus())
                    .build();
        }
}
