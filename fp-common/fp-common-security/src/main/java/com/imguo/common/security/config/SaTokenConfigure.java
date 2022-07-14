package com.imguo.common.security.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.id.SaIdUtil;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注解鉴权
 *
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
  // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
    registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
  }

//  @Bean
//  public SaServletFilter getSaServletFilter() {
//    return new SaServletFilter()
//        .addInclude("/**")
//        .addExclude("/favicon.ico")
//        .setAuth(
//            obj -> {
//              // 校验 Id-Token 身份凭证     —— 以下两句代码可简化为：SaIdUtil.checkCurrentRequestToken();
//              SaIdUtil.checkCurrentRequestToken();
//            })
//        .setError(
//            e -> {
//              return SaResult.error(e.getMessage());
//            });
//  }

  // Sa-Token 整合 jwt (Simple 简单模式)
  @Bean
  public StpLogic getStpLogicJwt() {
    return new StpLogicJwtForSimple();
  }
}
