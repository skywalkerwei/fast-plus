package com.imguo.model.sys.query;


import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 岗位管理
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class SysPostQuery {

    private String postCode;


    private String postName;

    private Integer status;

}
