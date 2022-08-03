package com.imguo.common.myabtis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CreateUpdateHandler implements MetaObjectHandler {

    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "updateTime";
    private final static String VERSION = "version";
    private final static String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insertFill");
        Date date = new Date();
        strictInsertFill(metaObject, CREATE_TIME, Date.class, date);
        strictInsertFill(metaObject, UPDATE_TIME, Date.class, date);
        // 版本号
        strictInsertFill(metaObject, VERSION, Integer.class, 0);
        // 删除标识
        strictInsertFill(metaObject, DELETED, Integer.class, 0);

    }


    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill");
        strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
//        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class,LocalDateTime.now());
    }
}
