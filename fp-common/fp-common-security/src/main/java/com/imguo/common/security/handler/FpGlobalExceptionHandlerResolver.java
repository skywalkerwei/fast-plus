package com.imguo.common.security.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.exception.FastException;
import com.imguo.common.core.util.FpLoggers;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 */
@RestControllerAdvice
public class FpGlobalExceptionHandlerResolver {


  @ExceptionHandler(NotLoginException.class)
  public Result<String> handlerNotLoginException(NotLoginException nle) {
    FpLoggers.info("FpGlobalExceptionHandlerResolver NotLoginException异常：{}", nle.getMessage());
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

  /**
   * 处理自定义异常
   */
  @ExceptionHandler(FastException.class)
  public Result<String> handleException(FastException ex){
    return Result.fail(ex.getCode(), ex.getMsg());
  }

  /**
   * SpringMVC参数绑定，Validator校验不正确
   */
  @ExceptionHandler(BindException.class)
  public Result<String> bindException(BindException ex) {
    FieldError fieldError = ex.getFieldError();
    assert fieldError != null;
    return Result.fail(fieldError.getDefaultMessage());
  }


  @ExceptionHandler(Exception.class)
  public Result<String> handleException(Exception ex){
    FpLoggers.error("handleException handleException ==== ", ex);
    return Result.fail(ex.getMessage());
//		return Result.fail(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ex.getMessage());
  }

}
