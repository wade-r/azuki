package com.ireul.dumb;

/**
 * This is wrapper exception for all Dumb exceptions
 *
 * @author Ryan Wade
 */
public class DumbException extends Exception {

    public DumbException(String s) {
        super(s);
    }

    public DumbException(Throwable e) {
        super(e);
    }
}
