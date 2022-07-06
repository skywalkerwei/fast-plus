package com.imguo.common.core.exception;

import lombok.extern.slf4j.Slf4j;
import com.imguo.common.core.entity.Result;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理器
 *
 */
@Slf4j
@RestControllerAdvice
public class FastExceptionHandler {
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
		log.error(ex.getMessage(), ex);
		return Result.fail(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
	}

}