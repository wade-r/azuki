package com.ireul.azuki.expressions.base;

import com.ireul.azuki.Azuki;
import com.ireul.azuki.AzukiException;

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
    public CombinationExpression(Object object) throws AzukiException {
        if (object == null) {
            this.expressions = Collections.emptyList();
        } else if (object instanceof List) {
            this.expressions = new ArrayList<>();
            for (Object o : (List<?>) object) {
                this.expressions.add(Azuki.build(o));
            }
        } else {
            throw new AzukiException(getClass().getName() + " must be constructed with a List object");
        }
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    private List<Expression> expressions;

}
