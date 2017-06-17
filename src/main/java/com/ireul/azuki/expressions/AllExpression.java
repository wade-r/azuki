package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.CombinationExpression;
import com.ireul.azuki.Expression;

import java.util.Map;

/**
 * 'all' expression
 *
 * @author Ryan Wade
 */
public class AllExpression extends CombinationExpression {

    public AllExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Expression expression : getExpressions()) {
            if (!expression.validate(map)) return false;
        }
        return true;
    }
}
