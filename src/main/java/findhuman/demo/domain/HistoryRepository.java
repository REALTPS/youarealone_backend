package findhuman.demo.domain;


import findhuman.demo.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    History findFirstByOrderByIdDesc();

    List<History> findByOrderByIdDesc();


}
