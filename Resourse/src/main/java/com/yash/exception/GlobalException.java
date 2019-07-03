package com.yash.exception;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class GlobalException {

//	@ExceptionHandler(Exception.class)
	public String handelException(HttpServletRequest request,Exception e){
		return e.getMessage();
	}
}
