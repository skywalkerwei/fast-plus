package com.imguo.service.wxapp.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imguo.model.common.service.impl.BaseServiceImpl;
import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.service.wxapp.dao.WxUserDao;
import com.imguo.service.wxapp.service.WxUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 */
@Service
@Slf4j
@AllArgsConstructor
public class WxUserServiceImpl extends BaseServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {

    @Override
    public void checkOpenID(WxMaJscode2SessionResult session) {
        WxUserEntity uEntity = baseMapper.selectOne(Wrappers.<WxUserEntity>lambdaQuery()
                .eq(WxUserEntity::getOpenid, session.getOpenid()));

        log.info("uEntity {}",uEntity);

        if (ObjectUtil.isNull(uEntity)) {
            uEntity = new WxUserEntity();
            uEntity.setOpenid(session.getOpenid());
            uEntity.setSessionKey(session.getSessionKey());
            uEntity.setUnionid(session.getUnionid());
        }
        saveOrUpdate(uEntity);

    }
}