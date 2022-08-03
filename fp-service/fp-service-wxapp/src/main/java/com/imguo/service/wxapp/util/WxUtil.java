package com.imguo.service.wxapp.util;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WxUtil {
//    @Autowired
//    private AlarmService alarmService; //业务类，用于保存小程序用户的openid
    @Autowired
    WxMaService wxMaService;

    public void saveOpenId(Long userId, String jsCode) {
        try {
            WxMaJscode2SessionResult code2SessionInfo = wxMaService.jsCode2SessionInfo(jsCode);
            if (code2SessionInfo != null) {
//                alarmService.addWechatLoginInfo(userId, code2SessionInfo.getOpenid(),
//                        code2SessionInfo.getSessionKey(), LocalDateTime.now());
            }
        } catch (Exception e) {
            log.error("保存微信登录信息发生错误错误~ [userId=" + userId + ", jsCode=" + jsCode, e);
        }
    }
}
