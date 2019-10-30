package findhuman.demo.dto;

import findhuman.demo.domain.History;
import findhuman.demo.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRequestDto {

    private Long id;

    private String name;

    private String company;

    private Integer serial;

    private String requester;

    private MemberRequestDto member;

    public History toEntity(){
        return History.builder()
                .id(id)
                .name(name)
                .company(company)
                .serial(serial)
                .date(LocalDateTime.now())
                .build();
    }
}
