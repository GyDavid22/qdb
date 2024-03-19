package com.qdb.qdb.exception;

/**
 * Exception to throw when an user doesn't have the rights to perform an action.
 * ONLY TO BE THROWN FROM EXCEPTIONSERVICE!
 */
public class NoRightException extends Exception {
    @Override
    public String getMessage() {
        return "User has no rights to perform this action";
    }
}
