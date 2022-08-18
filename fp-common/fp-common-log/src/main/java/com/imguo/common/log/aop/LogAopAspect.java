package com.imguo.common.log.aop;


import com.imguo.common.log.annotation.SysLog;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * AOP实现日志
 *
 * 
 * @since 2022/2/17 9:27
 */
@AllArgsConstructor
@Component
@Aspect
public class LogAopAspect {

//  private final FeignSysLogService feignSysLogService;

  /**
   * 环绕通知记录日志通过注解匹配到需要增加日志功能的方法
   *
   * 
   * @since 2022/2/17 9:28
   */
  @SneakyThrows
  @Around("@annotation(com.huanxing.cloud.common.log.annotation.SysLog)")
  public Object around(ProceedingJoinPoint point) {
    HttpServletRequest request =
        ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();
    // 1.方法执行前的处理，相当于前置通知
    // 获取方法签名
    MethodSignature methodSignature = (MethodSignature) point.getSignature();
    // 获取方法
    Method method = methodSignature.getMethod();
    // 获取方法上面的注解
    SysLog log = method.getAnnotation(SysLog.class);
    // 获取操作描述的属性值
    String title = log.value();
    // 记录日志


    // 让代理方法执行
    Long startTime = System.currentTimeMillis();
    Object result = null;
    try {
      result = point.proceed();

    } catch (Exception e) {

      throw e;
    } finally {
      Long endTime = System.currentTimeMillis();

      // 异步保存操作日志
      CompletableFuture.runAsync(
          () -> {
//            feignSysLogService.save(sysLog, SecurityConstants.SOURCE_IN);
          });
    }
    return result;
  }
}
