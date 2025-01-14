package com.ademozalp.bileton.dto.enums;

public enum ResponseMessage {
    LISTED(200, "Listed successfully"),
    IMPORTED(201, "Data imported successfully"),
    ;

    private final Integer code;
    private final String message;

    ResponseMessage(Integer code, String message) {
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
