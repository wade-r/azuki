package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.CombinationExpression;
import com.ireul.azuki.Expression;

import java.util.Map;

/**
 * 'none' expression
 *
 * @author Ryan Wade
 */
public class NoneExpression extends CombinationExpression {

    public NoneExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Expression expression : getExpressions()) {
            if (expression.validate(map)) {
                return false;
            }
        }
        return true;
    }
}
