package com.qdb.qdb.exception;

/**
 * Exception to throw when an image format isn't supported.
 */
public class UnsupportedFileFormatException extends Exception {
    @Override
    public String getMessage() {
        return "Supported file types: .jpg, .jpeg, .png";
    }
}
