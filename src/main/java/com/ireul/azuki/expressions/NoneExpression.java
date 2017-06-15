package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.expressions.base.CombinationExpression;
import com.ireul.azuki.expressions.base.Expression;

import java.util.Map;

/**
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
