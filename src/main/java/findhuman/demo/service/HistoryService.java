package findhuman.demo.service;

import findhuman.demo.model.domain.History;
import findhuman.demo.repository.HistoryRepository;
import findhuman.demo.model.domain.Member;
import findhuman.demo.repository.MemberRepository;
import findhuman.demo.model.dto.HistoryRequestDto;
import findhuman.demo.model.dto.api.HistoryListConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryListConverter historyListConverter;

    @Autowired
    private MemberRepository memberRepository;

    public HistoryService(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    public boolean addNewHistory(HistoryRequestDto historyDto) {

        Optional<Member> member = Optional.ofNullable(memberRepository.findByName(historyDto.getName()));

        return member.map(e -> {
            History newHistory = historyDto.toEntity();
            newHistory.setMember(e);
            historyRepository.save(newHistory);
            return true;
        }).orElse(false);
    }

    public List<HistoryRequestDto> getHistories() {
        return historyListConverter.convert(historyRepository.findByOrderByIdDesc());
    }
}
