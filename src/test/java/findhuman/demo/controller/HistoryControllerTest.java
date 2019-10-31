package findhuman.demo.controller;

import findhuman.demo.repository.HistoryRepository;
import findhuman.demo.service.HistoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryControllerTest {

    @Autowired
    private HistoryServiceImpl historyService;

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