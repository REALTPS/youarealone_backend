package findhuman.demo.service;

import findhuman.demo.domain.History;
import findhuman.demo.domain.HistoryRepository;
import findhuman.demo.domain.Member;
import findhuman.demo.domain.MemberRepository;
import findhuman.demo.dto.HistoryRequestDto;
import findhuman.demo.dto.api.HistoryConverter;
import findhuman.demo.dto.api.HistoryListConverter;
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
