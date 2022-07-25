package com.imguo.common.security.util;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.imguo.common.core.constant.CacheConstants;

import java.util.List;


public class SecuritySysUtils {


    public static UserDetail Login(long uid) {
        StpUtil.login(uid);
        return  new UserDetail(uid, StpUtil.getTokenInfo().tokenValue);
    }

    public static void   SetRole(List<String> roleList ){
        String  loginIdKey = CacheConstants.ROLE_CACHE ;
        StpUtil.getSession().set(loginIdKey, JSONUtil.toJsonStr(roleList));
    }

    public static List<String> GetRole(){
        String  loginIdKey = CacheConstants.ROLE_CACHE ;
        return JSONUtil.parseArray(StpUtil.getSession().get(loginIdKey))
                .toList(String.class);
    }

    public static void   SetPermission(List<String> roleList ){
        String  loginIdKey = CacheConstants.MENU_CACHE;
        StpUtil.getSession().set(loginIdKey, JSONUtil.toJsonStr(roleList));
    }

    public static List<String> GetPermission(){
        String  loginIdKey = CacheConstants.MENU_CACHE ;
        return JSONUtil.parseArray(StpUtil.getSession().get(loginIdKey))
                .toList(String.class);
    }

    public static UserDetail getInfo() {
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return new UserDetail(Long.valueOf(tokenInfo.loginId.toString()), tokenInfo.tokenValue);
    }

    public static Boolean isLogin() {
       return  StpUtil.isLogin();
    }

    public static void Logout() {
          StpUtil.logout();
    }

    public static void kickout() {
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        StpUtil.kickout(tokenInfo.loginId);
    }

}
