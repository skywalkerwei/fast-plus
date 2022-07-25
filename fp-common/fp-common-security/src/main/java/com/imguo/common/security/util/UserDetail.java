package com.imguo.common.security.util;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 登录用户信息
 *
 */
@Data
@AllArgsConstructor
public class UserDetail  {

    private Long uid;
    private String token;

}