package com.pony101.taskgeo.controllers.model;

public enum ResponseCode {

    SUCCESS(2000, "success"),
    RESOURCES_NOT_EXIST(4040, "Resources do not exist"),
    VALIDATION_ERROR(5001, "Validation error"),
    SERVICE_ERROR(5000, "Server exception");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
