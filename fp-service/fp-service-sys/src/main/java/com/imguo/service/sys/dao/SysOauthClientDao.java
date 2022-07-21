package com.imguo.service.sys.dao;

import com.imguo.model.common.dao.BaseDao;
import com.imguo.model.sys.entity.SysOauthClientEntity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户端管理
 *
 */
@Mapper
public interface SysOauthClientDao extends BaseDao<SysOauthClientEntity> {

    default SysOauthClientEntity getByClientId(String clientId){
        return this.selectOne(new QueryWrapper<SysOauthClientEntity>().eq("client_id", clientId));
    }
}
