package com.imguo.common.security.util;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.hutool.json.JSONUtil;
import com.imguo.common.core.constant.CacheConstants;
import com.imguo.common.security.at.user.StpUserUtil;

import java.util.List;

public class SecurityUserUtils {

    public static UserDetail Login(long uid) {
        StpUserUtil.login(uid);
        return new UserDetail(uid, StpUserUtil.getTokenInfo().tokenValue);
    }

    public static void  SetRole(List<String> roleList ){
        String  loginIdKey = CacheConstants.ROLE_CACHE ;
        StpUserUtil.getSession().set(loginIdKey, JSONUtil.toJsonStr(roleList));
    }

    public static List<String> GetRole(){
        String  loginIdKey = CacheConstants.ROLE_CACHE ;
        return JSONUtil.parseArray(StpUserUtil.getSession().get(loginIdKey))
                .toList(String.class);
    }

    public static void   SetPermission(List<String> roleList ){
        String  loginIdKey = CacheConstants.MENU_CACHE;
        StpUserUtil.getSession().set(loginIdKey, JSONUtil.toJsonStr(roleList));
    }

    public static List<String> GetPermission(){
        String  loginIdKey = CacheConstants.MENU_CACHE ;
        return JSONUtil.parseArray(StpUserUtil.getSession().get(loginIdKey))
                .toList(String.class);
    }


    public static UserDetail getInfo() {
        SaTokenInfo tokenInfo = StpUserUtil.getTokenInfo();
        return new UserDetail(Long.valueOf(tokenInfo.loginId.toString()), tokenInfo.tokenValue);
    }

    public static Boolean isLogin() {
        return  StpUserUtil.isLogin();
    }

    public static void Logout() {
        StpUserUtil.logout();
    }

    public static void kickout() {
        SaTokenInfo tokenInfo = StpUserUtil.getTokenInfo();
        StpUserUtil.kickout(tokenInfo.loginId);
    }

}
