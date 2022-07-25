package com.imguo.common.security.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.imguo.common.core.constant.CacheConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 自定义权限验证接口扩展
 *
 */
@Component
@Slf4j
public class FpPermissionsImpl implements StpInterface {

  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {
    // 返回此 loginId 拥有的权限列表
    String  loginIdKey = CacheConstants.MENU_CACHE;
    return ObjectUtil.isNotNull(StpUtil.getSession().get(loginIdKey))
        ? JSONUtil.parseArray(StpUtil.getSession().get(loginIdKey))
            .toList(String.class)
        : new ArrayList<>();
  }

  @Override
  public List<String> getRoleList(Object loginId, String loginType) {

    log.info("getRoleList"+loginId.toString());
    log.info("getRoleList" +loginType);
//    String  loginIdKey = CacheConstants.ROLE_CACHE + loginId.toString() ;
    String  loginIdKey = CacheConstants.ROLE_CACHE  ;
    return ObjectUtil.isNotNull(StpUtil.getSession().get(loginIdKey))
        ? JSONUtil.parseArray(StpUtil.getSession().get(loginIdKey))
            .toList(String.class)
        : new ArrayList<>();
  }
}
