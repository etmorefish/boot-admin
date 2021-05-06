package com.xxml.admin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createDate",Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "modifyDate",Date.class, new Date()); // 起始版本 3.3.0(推荐使用)

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start insert update ....");
        this.strictUpdateFill(metaObject, "modifyDate",Date.class, new Date()); // 起始版本 3.3.0(推荐使用)

    }
}
//    Date date = new Date();
//
//        this.strictInsertFill(metaObject, "createDate", String.class, date);
//        this.strictInsertFill(metaObject, "modifyDate", String.class, date);
