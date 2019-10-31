package findhuman.demo.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import findhuman.demo.model.domain.enumclass.memberStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
//@ToString(exclude = "historyList")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private memberStatus status;

    private String createBy;

    private LocalDateTime createAt;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<History> historyList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return status == member.status &&
                Objects.equals(id, member.id) &&
                Objects.equals(name, member.name) &&
                Objects.equals(createBy, member.createBy) &&
                Objects.equals(createAt, member.createAt) &&
                Objects.equals(historyList, member.historyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, createBy, createAt, historyList);
    }
}
