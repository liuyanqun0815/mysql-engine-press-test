package com.example.mysqlabletest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mysqlabletest.entity.TImMessage;
import com.example.mysqlabletest.service.TImMessageService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * IM消息记录表(TImMessage)表控制层
 *
 * @author makejava
 * @since 2024-07-26 18:20:06
 */
@RestController
@RequestMapping("tImMessage")
public class TImMessageController {


    @Resource
    private TImMessageService tImMessageService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;


    @GetMapping("insert")
    public void insertBatch(@RequestParam int num,@RequestParam int threadNum) {

        for (int i = 0; i < threadNum; i++) {
            taskExecutor.execute(() -> {
                tImMessageService.insertBatch(tImMessageList(num));
            });
        }
    }

    public List<TImMessage> tImMessageList(int num) {
        List<TImMessage> tImMessageList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TImMessage tImMessage = new TImMessage();
            tImMessage.setContent("{\n" +
                    "  \"name\": \"John Doe\",\n" +
                    "  \"age\": 30,\n" +
                    "  \"isStudent\": false,\n" +
                    "  \"courses\": [\"Math\", \"Science\", \"History\"],\n" +
                    "  \"address\": {\n" +
                    "    \"street\": \"123 Main St\",\n" +
                    "    \"city\": \"Anytown\",\n" +
                    "    \"zip\": \"12345\"\n" +
                    "  }\n" +
                    "}");
            tImMessage.setEvent("接收服务端请求");
            tImMessage.setEventTime(System.currentTimeMillis());
            String uuid = UUID.randomUUID().toString().replace("-", "");
            tImMessage.setMsgId(uuid);
            tImMessage.setReceiver(uuid);
            tImMessage.setSender(uuid);
            tImMessageList.add(tImMessage);
        }
        return tImMessageList;

    }
}

