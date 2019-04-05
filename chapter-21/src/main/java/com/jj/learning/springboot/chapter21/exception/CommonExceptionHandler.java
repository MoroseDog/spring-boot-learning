package com.jj.learning.springboot.chapter21.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        return result;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String, Object> handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "01002");
        result.put("respMsg", fieldError.getDefaultMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "01003");
        result.put("respMsg", fieldError.getDefaultMessage());
        return result;
    }

}
