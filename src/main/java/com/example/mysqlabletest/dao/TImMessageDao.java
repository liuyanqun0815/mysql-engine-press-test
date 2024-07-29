package com.example.mysqlabletest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysqlabletest.entity.TImMessage;
import org.springframework.stereotype.Repository;

/**
 * IM消息记录表(TImMessage)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 18:20:08
 */

@Repository
public interface TImMessageDao extends BaseMapper<TImMessage> {

}

