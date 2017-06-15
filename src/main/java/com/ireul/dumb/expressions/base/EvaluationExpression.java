package com.ireul.dumb.expressions.base;

import com.ireul.dumb.DumbException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides abstraction for Evaluation Expressions, such as 'equals', 'startsWith'
 *
 * @author Ryan Wade
 */
public abstract class EvaluationExpression extends Expression {

    private Map<String, String> values;

    public Map<String, String> getValues() {
        return values;
    }

    @SuppressWarnings("unchecked")
    public EvaluationExpression(Object object) throws DumbException {
        if (object == null) {
            this.values = Collections.emptyMap();
        } else if (object instanceof Map) {
            this.values = new HashMap<>();
            for (Map.Entry entry : ((Map<?, ?>) object).entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    throw new DumbException("key must be string");
                }
                if (!(entry.getValue() instanceof String)) {
                    throw new DumbException("value must be string");
                }
                this.values.put((String) entry.getKey(), (String) entry.getValue());
            }
        } else {
            throw new DumbException(getClass().getName() + " must be constructed with a Map<String,String> object");
        }
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

}
