package com.ademozalp.bileton.dto.enums;

public enum ErrorMessage {
    LOCATION_NOT_FOUND(1001, "Location not found"),
    LOCATION_ALREADY_EXISTS(1002, "Location already exists"),
    ;

    private final Integer code;
    private final String message;

    ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
