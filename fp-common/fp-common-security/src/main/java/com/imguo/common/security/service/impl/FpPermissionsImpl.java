package com.imguo.common.security.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.imguo.common.core.constant.CacheConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 */
@Component
public class FpPermissionsImpl implements StpInterface {

  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {
    // 返回此 loginId 拥有的权限列表
    return ObjectUtil.isNotNull(StpUtil.getSession().get(CacheConstants.MENU_CACHE))
        ? JSONUtil.parseArray(StpUtil.getSession().get(CacheConstants.MENU_CACHE))
            .toList(String.class)
        : new ArrayList<>();
  }

  @Override
  public List<String> getRoleList(Object loginId, String loginType) {
    return ObjectUtil.isNotNull(StpUtil.getSession().get(CacheConstants.ROLE_CACHE))
        ? JSONUtil.parseArray(StpUtil.getSession().get(CacheConstants.ROLE_CACHE))
            .toList(String.class)
        : new ArrayList<>();
  }
}
