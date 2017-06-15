package com.ireul.azuki.expressions.base;

import com.ireul.azuki.Azuki;
import com.ireul.azuki.AzukiException;

import java.util.Map;

/**
 * This class provides abstraction for Wrapper Expressions, basically for 'not'
 *
 * @author Ryan Wade
 */
public abstract class WrapperExpression extends Expression {

    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public WrapperExpression(Object object) throws AzukiException {
        if (object == null) {
            this.expression = null;
        } else if (object instanceof Map) {
            this.expression = Azuki.build(object);
        } else {
            throw new AzukiException(getClass() + " must be constructed with a Map");
        }
    }

}
