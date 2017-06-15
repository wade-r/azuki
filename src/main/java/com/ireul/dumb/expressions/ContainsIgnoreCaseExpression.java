package com.ireul.dumb.expressions;

import com.ireul.dumb.DumbException;
import com.ireul.dumb.expressions.base.EvaluationExpression;

import java.util.Map;

/**
 * Created by ryan on 2017/6/16.
 */
public class ContainsIgnoreCaseExpression extends EvaluationExpression {

    public ContainsIgnoreCaseExpression(Object object) throws DumbException {
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
