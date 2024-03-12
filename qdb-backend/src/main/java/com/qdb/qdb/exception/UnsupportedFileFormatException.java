package com.qdb.qdb.exception;

public class UnsupportedFileFormatException extends Exception {
    @Override
    public String getMessage() {
        return "Supported file types: .jpg, .jpeg, .png";
    }
}
