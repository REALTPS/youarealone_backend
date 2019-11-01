package findhuman.demo.model.dto;

import findhuman.demo.model.domain.Member;
import findhuman.demo.model.domain.enumclass.memberStatus;
import lombok.*;

import java.util.Objects;

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

    @Override
    public String toString() {

        String result = "id : " + id + ", name : " + name + ", status : " + status.getTitle();

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberRequestDto that = (MemberRequestDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }
}
