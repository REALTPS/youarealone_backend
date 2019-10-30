package findhuman.demo.controller;

import findhuman.demo.domain.History;
import findhuman.demo.dto.HistoryRequestDto;
import findhuman.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping("/history/add")
    public String addNewHistory (@RequestBody HistoryRequestDto history) {
        boolean isOk = historyService.addNewHistory(history);
        if(isOk) {
            return "OK";
        } else {
            return "실패";
        }
    }

    @GetMapping("/history/all")
    public List<HistoryRequestDto> getHistories(){
        return historyService.getHistories();
    }



//
//    @GetMapping("/entity/list")
//    @PostMapping("/entity/add")
//    @PostMapping("/entity/fix")
//    @DeleteMapping("/entity/del/{name}")



}
