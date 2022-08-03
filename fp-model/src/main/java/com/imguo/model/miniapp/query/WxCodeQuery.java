package com.imguo.model.miniapp.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.imguo.model.common.query.Query;

import javax.validation.constraints.NotNull;

/**
 * 字典数据
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "字典数据查询")
public class WxCodeQuery  {
    @Schema(description = "code", required = true)
    @NotNull(message = "code不能为空")
    private String code;

}
