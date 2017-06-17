package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.EvaluationExpression;

import java.util.Map;

/**
 * 'startsWithIgnoreCase' expression
 *
 * @author Ryan Wade
 */
public class StartsWithIgnoreCaseExpression extends EvaluationExpression {

    public StartsWithIgnoreCaseExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            if (value == null || !value.toLowerCase().startsWith(entry.getValue().toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
