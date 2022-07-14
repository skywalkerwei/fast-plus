package com.imguo.common.myabtis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class CreateUpdateHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insertFill");
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class,LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class,LocalDateTime.now());
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill");
        this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class,LocalDateTime.now());
    }
}
