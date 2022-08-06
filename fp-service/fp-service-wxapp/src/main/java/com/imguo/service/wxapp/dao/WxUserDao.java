package com.imguo.service.wxapp.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imguo.model.common.dao.BaseDao;
import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.model.sys.entity.SysUserEntity;


public interface WxUserDao  extends BaseDao<WxUserEntity> {

    default WxUserEntity getByOpenId(String openId){
        return this.selectOne(new QueryWrapper<WxUserEntity>().eq("openId", openId));
    }

}
