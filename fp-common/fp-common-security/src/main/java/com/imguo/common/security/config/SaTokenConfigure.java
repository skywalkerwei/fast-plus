package com.imguo.common.security.config;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.strategy.SaStrategy;
import com.imguo.common.security.at.user.StpUserUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

/**
 * 注解鉴权
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class SaTokenConfigure implements WebMvcConfigurer {
  private final HttpServletRequest request;
  // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
    registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
  }

  @Autowired
  public void rewriteSaStrategy() {
    // 重写Sa-Token的注解处理器，增加注解合并功能
    SaStrategy.me.getAnnotation = (element, annotationClass) -> {
      return AnnotatedElementUtils.getMergedAnnotation(element, annotationClass);
    };
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

  @Autowired
  public void setUserStpLogic() {
    StpUserUtil.stpLogic = new StpLogicJwtForSimple(StpUserUtil.TYPE);
    SaManager.putStpLogic(StpUserUtil.stpLogic);
  }

  /**
   * 重写 Sa-Token 框架内部算法策略
   */
//  @Autowired
//  public void rewriteSaStrategy() {
//    // 重写Sa-Token的注解处理器，增加注解合并功能
//    SaStrategy.me.getAnnotation = (element, annotationClass) -> {
//      return AnnotatedElementUtils.getMergedAnnotation(element, annotationClass);
//    };
//  }

  /**
   * 内部接口访问权限
   *
   */
  @Bean
  public com.imguo.common.security.aop.FpInnerAopAspect hxInnerAopAspect() {
    return new com.imguo.common.security.aop.FpInnerAopAspect(request);
  }

}
