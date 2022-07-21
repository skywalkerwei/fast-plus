package com.imguo.common.security.util;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.imguo.common.security.at.StpUserUtil;

public class SecurityUtils {

    public static SaTokenInfo getTokenInfo() {
        return StpUtil.getTokenInfo();
    }

    public static SaTokenInfo getUserTokenInfo() {
        return StpUserUtil.getTokenInfo();
    }

    public static long getSysUserId() {
        return (long) StpUtil.getTokenInfo().loginId;
    }
    public static long getUserId() {
        return (long) StpUserUtil.getTokenInfo().loginId;
    }


}
