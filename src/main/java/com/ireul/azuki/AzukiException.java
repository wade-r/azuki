package com.ireul.azuki;

/**
 * This is wrapper exception for all Azuki exceptions
 *
 * @author Ryan Wade
 */
public class AzukiException extends Exception {

    public AzukiException(String s) {
        super(s);
    }

    public AzukiException(Throwable e) {
        super(e);
    }
}
