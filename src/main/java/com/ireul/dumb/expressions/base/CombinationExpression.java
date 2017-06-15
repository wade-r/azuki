package com.ireul.dumb.expressions.base;

import com.ireul.dumb.Dumb;
import com.ireul.dumb.DumbException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class provides a abstraction for Combination Expressions, such as 'any', 'all', 'none'
 *
 * @author Ryan Wade
 */
public abstract class CombinationExpression extends Expression {

    public List<Expression> getExpressions() {
        return expressions;
    }

    @SuppressWarnings("unchecked")
    public CombinationExpression(Object object) throws DumbException {
        if (object == null) {
            this.expressions = Collections.emptyList();
        } else if (object instanceof List) {
            this.expressions = new ArrayList<>();
            for (Object o : (List<?>) object) {
                this.expressions.add(Dumb.build(o));
            }
        } else {
            throw new DumbException(getClass().getName() + " must be constructed with a List object");
        }
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    private List<Expression> expressions;

}
