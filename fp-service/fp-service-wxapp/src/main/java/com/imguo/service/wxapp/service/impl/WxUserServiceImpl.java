package com.imguo.service.wxapp.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imguo.common.core.exception.FastException;
import com.imguo.model.common.service.impl.BaseServiceImpl;
import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.service.wxapp.dao.WxUserDao;
import com.imguo.service.wxapp.service.WxUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 */
@Service
@AllArgsConstructor
public class WxUserServiceImpl extends BaseServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {

    @Override
    public WxUserEntity checkOpenID(WxMaJscode2SessionResult session) {
        WxUserEntity uEntity = baseMapper.selectOne(Wrappers.<WxUserEntity>lambdaQuery()
                .eq(WxUserEntity::getOpenid, session.getOpenid()));

        if (ObjectUtil.isNull(uEntity)) {
            uEntity = new WxUserEntity();
            uEntity.setOpenid(session.getOpenid());
        }
        uEntity.setUnionid(session.getUnionid());
        uEntity.setSessionKey(session.getSessionKey());
        saveOrUpdate(uEntity);

        return  uEntity;

    }

    @Override
    public WxUserEntity queryByOpenId(String openId) {
        WxUserEntity entity = baseMapper.getByOpenId(openId);
        if(entity == null){
            throw new FastException("用户不存在");
        }
        return entity;
    }

    @Override
    public void updateWxMaUserInfo(String openId, WxMaUserInfo wxMaUserInfo) {

        LambdaUpdateWrapper<WxUserEntity> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(WxUserEntity::getOpenid, openId).
                set(WxUserEntity::getAvatarUrl, wxMaUserInfo.getAvatarUrl()).
                set(WxUserEntity::getNickName, wxMaUserInfo.getNickName());
        baseMapper.update(null, lambdaUpdateWrapper);


    }

    @Override
    public void updateWxMaPhoneNumberInfo(String openId, WxMaPhoneNumberInfo phoneNoInfo) {

        LambdaUpdateWrapper<WxUserEntity> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(WxUserEntity::getOpenid, openId).
                set(WxUserEntity::getPhone, phoneNoInfo.getPurePhoneNumber());
        baseMapper.update(null, lambdaUpdateWrapper);

    }
}