package com.ireul.dumb.expressions.base;

import com.ireul.dumb.Dumb;
import com.ireul.dumb.DumbException;

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

    public WrapperExpression(Object object) throws DumbException {
        if (object == null) {
            this.expression = null;
        } else if (object instanceof Map) {
            this.expression = Dumb.build(object);
        } else {
            throw new DumbException(getClass() + " must be constructed with a Map");
        }
    }

}
