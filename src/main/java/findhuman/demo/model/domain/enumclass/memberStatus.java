package findhuman.demo.model.domain.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum memberStatus {

    ACTIVATE(0, "근무", "팝사랑"),
    DEACTIVATE(1, "퇴사", "배신자"),
    HOLIDAY(2, "휴가", "휴가자")
    ;

    private Integer id;
    private String title;
    private String description;

}

