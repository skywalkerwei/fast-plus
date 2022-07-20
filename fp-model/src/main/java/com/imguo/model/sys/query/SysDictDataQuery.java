package com.imguo.model.sys.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;

/**
 * 字典数据
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictDataQuery  {
    @NotNull(message = "字典类型ID不能为空")
    private Long dictTypeId;

}
