package com.qdb.qdb.exception;

public class NoRightException extends Exception {
    @Override
    public String getMessage() {
        return "User has no rights to perform this action";
    }
}
