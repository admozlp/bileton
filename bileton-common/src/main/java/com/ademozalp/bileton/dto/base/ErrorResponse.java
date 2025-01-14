package com.ademozalp.bileton.dto.base;


public record ErrorResponse(String message, Integer code) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;
        private Integer code;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder code(Integer code) {
            this.code = code;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(message, code);
        }
    }
}
