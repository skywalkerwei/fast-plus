package com.imguo.common.security.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import com.imguo.common.core.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 */
@Slf4j
@RestControllerAdvice
public class FpGlobalExceptionHandlerResolver {


  @ExceptionHandler(NotLoginException.class)
  public Result<String> handlerNotLoginException(NotLoginException nle) {
    log.info("FpGlobalExceptionHandlerResolver NotLoginException异常：{}", nle.getMessage());
    // 打印堆栈，以供调试
    nle.printStackTrace();
    // 判断场景值，定制化异常信息
    String message = "";
    int code = -1;
    if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
      message = "未提供token";
      code = 10001;
    } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
      message = "token无效";
      code = 10002;
    } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
      message = "token已过期";
      code = 10003;
    } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
      message = "token已被顶下线";
      code = 10004;
    } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
      message = "token已被踢下线";
      code = 10005;
    } else {
      message = "当前会话未登录";
      code = 10006;
    }
    return Result.fail(code,message);
  }
  //
  @ExceptionHandler(SaTokenException.class)
  public Result<String> handleException(SaTokenException ex){
    String message = "token无效";
    int code = 10002;
    return Result.fail(code,message);
  }

}
