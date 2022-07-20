package com.imguo.model.sys.query;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictTypeQuery {
    private String dictType;

    private String dictName;

}
