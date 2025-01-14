package com.ademozalp.bileton.exception.type;

import com.ademozalp.bileton.dto.enums.ErrorMessage;

public class TripException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public TripException(ErrorMessage errorMessage) {
        super(errorMessage.message());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
