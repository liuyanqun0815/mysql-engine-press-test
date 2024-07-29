package com.example.mysqlabletest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mysqlabletest.entity.TImMessage;

import java.util.List;

/**
 * IM消息记录表(TImMessage)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 18:20:09
 */
public interface TImMessageService extends IService<TImMessage> {

    void insertBatch(List<TImMessage> tImMessageList);

}

