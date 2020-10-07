package com.pony101.taskgeo.exception;

import com.pony101.taskgeo.controllers.model.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private ResponseCode code;

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, ResponseCode code) {
        super(cause);
        this.code = code;
    }

}
