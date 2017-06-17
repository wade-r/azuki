package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.CombinationExpression;
import com.ireul.azuki.Expression;

import java.util.Map;

/**
 * 'any' expression
 *
 * @author Ryan Wade
 */
public class AnyExpression extends CombinationExpression {

    public AnyExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Expression expression : getExpressions()) {
            if (expression.validate(map)) return true;
        }
        return false;
    }

}
