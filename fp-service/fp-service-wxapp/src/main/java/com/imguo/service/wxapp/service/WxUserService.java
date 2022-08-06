package com.imguo.service.wxapp.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;


import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.miniapp.entity.WxUserEntity;



/**
 * 微信用户
 *
 */
public interface WxUserService extends BaseService<WxUserEntity> {

    WxUserEntity checkOpenID(WxMaJscode2SessionResult session);

    WxUserEntity queryByOpenId(String openId);

    void  updateWxMaUserInfo(String openId, WxMaUserInfo wxMaUserInfo);

    void  updateWxMaPhoneNumberInfo(String openId, WxMaPhoneNumberInfo phoneNoInfo);



}
