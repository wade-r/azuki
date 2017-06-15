package com.ireul.dumb.expressions.base;

import java.util.Map;

/**
 * This is base class for expression types
 *
 * @author Ryan Wade
 */
public abstract class Expression {

    /**
     * Evaluate expression on target map
     *
     * @param map target map
     * @return validation passed or not
     */
    public abstract boolean validate(Map<String, String> map);

}
