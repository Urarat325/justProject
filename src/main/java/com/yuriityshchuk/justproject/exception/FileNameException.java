package com.yuriityshchuk.justproject.exception;

public class FileNameException extends RuntimeException {

    public FileNameException() {
    }

    public FileNameException(String message) {
        super(message);
    }

    public FileNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
