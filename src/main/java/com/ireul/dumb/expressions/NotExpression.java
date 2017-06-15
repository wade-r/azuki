package com.ireul.dumb.expressions;

import com.ireul.dumb.DumbException;
import com.ireul.dumb.expressions.base.WrapperExpression;

import java.util.Map;

/**
 * @author Ryan Wade
 */
public class NotExpression extends WrapperExpression {

    public NotExpression(Object object) throws DumbException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        return !(getExpression() != null && getExpression().validate(map));
    }

}
