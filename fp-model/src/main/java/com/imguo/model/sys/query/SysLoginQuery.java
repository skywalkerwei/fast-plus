package com.imguo.model.sys.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 用户查询
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(description = "登录")
public class SysLoginQuery  {
    @Schema(description = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码")
    @NotNull(message = "密码不能为空")
    private String password;

//    @Schema(description = "验证码")
//    @NotNull(message = "验证码不能为空")
//    private String captcha;

}