package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.expressions.base.WrapperExpression;

import java.util.Map;

/**
 * @author Ryan Wade
 */
public class NotExpression extends WrapperExpression {

    public NotExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        return getExpression() == null || !getExpression().validate(map);
    }

}
