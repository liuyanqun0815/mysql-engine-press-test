package com.example.mysqlabletest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysqlabletest.dao.TImMessageDao;
import com.example.mysqlabletest.entity.TImMessage;
import com.example.mysqlabletest.service.TImMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IM消息记录表(TImMessage)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 18:20:10
 */
@Service("tImMessageService")
public class TImMessageServiceImpl extends ServiceImpl<TImMessageDao, TImMessage> implements TImMessageService {

    public void insertBatch(List<TImMessage> tImMessageList) {
        this.saveBatch(tImMessageList);
    }


}

