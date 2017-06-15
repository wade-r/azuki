package com.ireul.dumb.expressions;

import com.ireul.dumb.DumbException;
import com.ireul.dumb.expressions.base.CombinationExpression;
import com.ireul.dumb.expressions.base.Expression;

import java.util.Map;

/**
 * @author Ryan Wade
 */
public class NoneExpression extends CombinationExpression {

    public NoneExpression(Object object) throws DumbException {
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
