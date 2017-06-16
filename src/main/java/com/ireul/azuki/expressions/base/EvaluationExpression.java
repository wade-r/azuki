package com.ireul.azuki.expressions.base;

import com.ireul.azuki.AzukiException;

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
    public EvaluationExpression(Object object) throws AzukiException {
        if (object == null) {
            this.values = Collections.emptyMap();
        } else if (object instanceof Map) {
            this.values = new HashMap<>();
            for (Map.Entry entry : ((Map<?, ?>) object).entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    throw new AzukiException("key must be string");
                }
                if (!(entry.getValue() instanceof String)) {
                    entry.setValue(entry.getValue().toString());
                }
                this.values.put((String) entry.getKey(), (String) entry.getValue());
            }
        } else {
            throw new AzukiException(getClass().getName() + " must be constructed with a Map<String,String> object");
        }
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

}
