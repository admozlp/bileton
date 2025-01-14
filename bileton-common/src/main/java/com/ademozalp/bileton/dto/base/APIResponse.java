package com.ademozalp.bileton.dto.base;

public record APIResponse<T>(String message, Integer code, T data) {
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private String message;
        private Integer code;
        private T data;

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public APIResponse<T> build() {
            return new APIResponse<>(message, code, data);
        }
    }
}
