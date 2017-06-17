package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.EvaluationExpression;

import java.util.Map;

/**
 * 'containsIgnoreCase' expression
 *
 * @author Ryan Wade
 */
public class ContainsIgnoreCaseExpression extends EvaluationExpression {

    public ContainsIgnoreCaseExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            if (value == null || !value.toLowerCase().contains(entry.getValue().toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
