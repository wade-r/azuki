package com.ireul.azuki;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides abstraction for Evaluation Expressions, such as 'equals', 'startsWith'
 * <p>Should be constructed by a Map from String to String</p>
 * <p>Should return true when all key-value pairs are passed</p>
 * <pre>
 *     evaluationExpression:
 *       key1: value1
 *       key2: value2
 * </pre>
 *
 * @author Ryan Wade
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class EvaluationExpression implements Expression {

    private Map<String, String> values;

    /**
     * Get values
     *
     * @return values
     */
    public Map<String, String> getValues() {
        return values;
    }

    /**
     * Set values
     *
     * @param values values
     */
    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    /**
     * Construct with a String-to-String Map
     *
     * @param object should be a Map, key should be String, and value will be converted to String
     * @throws AzukiException error occurred
     */
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
                this.values.put((String) entry.getKey(), entry.getValue().toString());
            }
        } else {
            throw new AzukiException(getClass().getName() + " must be constructed with a Map<String,String> object");
        }
    }

}
