package com.imguo.service.wxapp.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;


import com.imguo.model.common.service.BaseService;
import com.imguo.model.miniapp.entity.WxUserEntity;



/**
 * 微信用户
 *
 */
public interface WxUserService extends BaseService<WxUserEntity> {

    WxUserEntity checkOpenID(WxMaJscode2SessionResult session);

}
