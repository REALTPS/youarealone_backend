package findhuman.demo.dto;

import findhuman.demo.domain.Member;
import findhuman.demo.domain.enumclass.memberStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

    private Long id;
    private String name;
    private memberStatus status;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .status(status)
                .build();
    }

}
