package com.imguo.service.goods.query;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户查询
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class SysUserQuery  {

    private String username;


    private String mobile;


    private Integer gender;

}
