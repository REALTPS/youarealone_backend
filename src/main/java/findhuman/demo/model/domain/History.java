package findhuman.demo.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime date;

    private Integer serial;

    private String company;

    private String requester;

    @JsonBackReference
    @ManyToOne
//    @JoinColumn(name = "member_id")
    private Member member;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) &&
                Objects.equals(name, history.name) &&
                Objects.equals(date, history.date) &&
                Objects.equals(serial, history.serial) &&
                Objects.equals(company, history.company) &&
                Objects.equals(requester, history.requester) &&
                Objects.equals(member, history.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, serial, company, requester, member);
    }
}
