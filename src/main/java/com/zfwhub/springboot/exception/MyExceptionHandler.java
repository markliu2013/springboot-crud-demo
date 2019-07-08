package com.zfwhub.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfwhub.springboot.dto.BaseResponse;
import com.zfwhub.springboot.dto.ResponseError;

@ControllerAdvice
public class MyExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse defaultExceptionHandler(HttpServletRequest req, Exception e) {
        ResponseError responseError = new ResponseError(1, e.getMessage());
        return responseError;
    }
    
}
