package findhuman.demo.dto.api;

import findhuman.demo.domain.History;
import findhuman.demo.dto.HistoryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryListConverter implements Converter<List<History>, List<HistoryRequestDto>> {

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public List<HistoryRequestDto> convert(List<History> historyList) {
        List<HistoryRequestDto> dtos = new ArrayList<>();
        for (History history : historyList) {
            HistoryRequestDto dto = new HistoryRequestDto();
            dto.setId(history.getId());
            dto.setName(history.getName());
            dto.setCompany(history.getCompany());
            dto.setSerial(history.getSerial());
            dto.setRequester(history.getRequester());
            dto.setMember(memberConverter.convert(history.getMember()));
            dtos.add(dto);
        }
        return dtos;
    }
}
