package com.ireul.azuki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class provides a abstraction for Combination Expressions, such as 'any', 'all', 'none'
 * <p>Should be constructed by a list of map</p>
 * <pre>
 *   combinationExpression:
 *     - evaluationExpression:
 *         key: value
 *     - anotherCombinationExpression:
 *         - anotherEvaluationExpress:
 *             key2: value2
 * </pre>
 *
 * @author Ryan Wade
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class CombinationExpression implements Expression {

    private List<Expression> expressions;

    /**
     * Get internal expressions
     *
     * @return internal expressions
     */
    public List<Expression> getExpressions() {
        return expressions;
    }

    /**
     * Set internal expressions
     *
     * @param expressions new internal expressions
     */
    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    /**
     * Create a Combination Expression
     *
     * @param object should be a List of Map, each element will be passed to {@link Azuki#build(Object)}
     * @throws AzukiException error occurred
     */
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

}
