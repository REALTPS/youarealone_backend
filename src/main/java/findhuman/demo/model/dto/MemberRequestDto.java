package findhuman.demo.model.dto;

import findhuman.demo.model.domain.Member;
import findhuman.demo.model.domain.enumclass.memberStatus;
import lombok.*;

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
