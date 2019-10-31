package findhuman.demo.service;

import findhuman.demo.model.dto.HistoryRequestDto;

import java.util.List;

public interface HistoryService {

    boolean addNewHistory(HistoryRequestDto historyDto);

    List<HistoryRequestDto> getHistories();

}
