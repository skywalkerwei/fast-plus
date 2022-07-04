package com.imguo.common.security.aop;

import cn.hutool.core.util.StrUtil;
import com.imguo.common.core.constant.SecurityConstants;
import com.imguo.common.security.annotation.FpInner;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
/**
 * 内部接口调用处理 aop
 *
 * @author lijx
 * @date 2022/6/28
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class FpInnerAopAspect {
  private final HttpServletRequest request;

  @SneakyThrows
  @Around("@annotation(com.imguo.common.security.annotation.FpInner)")
  public Object around(ProceedingJoinPoint point) {
    // 获取方法签名
    MethodSignature methodSignature = (MethodSignature) point.getSignature();
    // 获取方法
    Method method = methodSignature.getMethod();
    // 获取方法上面的注解
    FpInner fpInner = method.getAnnotation(FpInner.class);
    String header = request.getHeader(SecurityConstants.SOURCE);
    if (fpInner.value() && !StrUtil.equals(SecurityConstants.SOURCE_IN, header)) {
      log.warn("访问接口 {} 没有权限", point.getSignature().getName());
      throw new RuntimeException("无权访问");
    }
    return point.proceed();
  }
}
