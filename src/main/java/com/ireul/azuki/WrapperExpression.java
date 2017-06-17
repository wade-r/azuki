package com.ireul.azuki;

import java.util.Map;

/**
 * This class provides abstraction for Wrapper Expressions
 * <p>It wraps one another expressions, basically designed for 'not' expression</p>
 *
 * @author Ryan Wade
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class WrapperExpression implements Expression {

    private Expression expression;

    /**
     * Get the wrapped expression
     *
     * @return wrapped expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Set the wrapped expression
     *
     * @param expression wrapped expression
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Create a WrapperExpression with a Map
     *
     * @param object should be a Map, will be passed to {@link Azuki#build(Object)}
     * @throws AzukiException exception
     */
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
