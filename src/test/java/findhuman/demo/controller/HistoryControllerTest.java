package findhuman.demo.controller;

import findhuman.demo.domain.HistoryRepository;
import findhuman.demo.service.HistoryService;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryControllerTest {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryRepository historyRepository;

    @Before
    public void setUp(){
//        historyService = new HistoryService(historyRepository);
    }

    @Test
    public void repoRead(){
        Assert.assertNotNull(historyService);
    }



}