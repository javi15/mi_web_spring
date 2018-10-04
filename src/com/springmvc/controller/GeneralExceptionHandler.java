package com.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception ex){
		
		return "error";
	}
}
