package com.ireul.dumb.expressions;

import com.ireul.dumb.DumbException;
import com.ireul.dumb.expressions.base.EvaluationExpression;

import java.util.Map;

/**
 * @author Ryan Wade
 */
public class EqualsIgnoreCaseExpression extends EvaluationExpression {

    public EqualsIgnoreCaseExpression(Object object) throws DumbException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            if (value == null || !value.equalsIgnoreCase(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

}
