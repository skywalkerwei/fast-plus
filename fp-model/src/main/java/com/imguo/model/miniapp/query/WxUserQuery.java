package com.imguo.model.miniapp.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "WxUserQuery")
public class WxUserQuery {

    @Schema(description = "openId", required = true)
    @NotNull(message = "openId不能为空")
    private String openId;

    @Schema(description = "encryptedData", required = true)
    @NotNull(message = "encryptedData不能为空")
    private String encryptedData;

    @Schema(description = "iv", required = true)
    @NotNull(message = "iv不能为空")
    private String iv;



}
