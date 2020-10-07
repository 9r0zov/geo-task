package com.pony101.taskgeo.advice;

import com.pony101.taskgeo.controllers.model.ResponseCode;
import com.pony101.taskgeo.controllers.model.ResponseResult;
import com.pony101.taskgeo.exception.BaseException;
import com.pony101.taskgeo.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseResult handleBindException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseResult(ResponseCode.VALIDATION_ERROR.getCode(), ResponseCode.VALIDATION_ERROR.getMsg(), errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(), e.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        ResponseCode code = e.getCode();
        return new ResponseResult(code.getCode(), code.getMsg(), e.getMessage());
    }

}
