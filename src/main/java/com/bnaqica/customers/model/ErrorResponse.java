package com.bnaqica.customers.model;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class ErrorResponse implements Serializable {
    private final String message;

    public static ErrorResponse.ErrorResponseBuilder builder() {
        return new ErrorResponse.ErrorResponseBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    @ConstructorProperties({"message"})
    public ErrorResponse(String message) {
        this.message = message;
    }

    public static class ErrorResponseBuilder {
        private String message;

        ErrorResponseBuilder() {
        }

        public ErrorResponse.ErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.message);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(message=" + this.message + ")";
        }
    }
}
