package com.imguo.common.security.at.merchant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;

/**
 * 权限认证(merchant版)：必须具有指定权限才能进入该方法
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 */
@SaCheckPermission(type = StpMerchantUtil.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaMerchantCheckPermission {

	/**
	 * 需要校验的权限码
	 * @return 需要校验的权限码
	 */
	@AliasFor(annotation = SaCheckPermission.class)
	String [] value() default {};

	/**
	 * 验证模式：AND | OR，默认AND
	 * @return 验证模式
	 */
	@AliasFor(annotation = SaCheckPermission.class)
	SaMode mode() default SaMode.AND;
	
}