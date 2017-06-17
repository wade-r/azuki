package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.EvaluationExpression;

import java.util.Map;

/**
 * 'exists' evaluation
 *
 * @author Ryan Wade
 */
public class ExistsExpression extends EvaluationExpression {

    public ExistsExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            String boolValue = entry.getValue();
            if (boolValue == null
                    || boolValue.toLowerCase().startsWith("f")
                    || boolValue.toLowerCase().startsWith("n")) {
                if (value != null && !value.isEmpty()) {
                    return false;
                }
            } else {
                if (value == null
                        || value.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

}
