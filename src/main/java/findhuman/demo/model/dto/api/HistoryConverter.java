package findhuman.demo.model.dto.api;

import findhuman.demo.model.domain.History;
import findhuman.demo.model.dto.HistoryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryConverter implements Converter<History, HistoryRequestDto> {

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public HistoryRequestDto convert(History history) {
        return HistoryRequestDto.builder()
                .id(history.getId())
                .name(history.getName())
                .serial(history.getSerial())
                .requester(history.getRequester())
                .company(history.getCompany())
                .member(memberConverter.convert(history.getMember()))
                .build();
    }
}