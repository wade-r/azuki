package com.ireul.dumb.expressions;

import com.ireul.dumb.DumbException;
import com.ireul.dumb.expressions.base.EvaluationExpression;

import java.util.Map;

/**
 * Created by ryan on 2017/6/16.
 */
public class StartsWithExpression extends EvaluationExpression {

    public StartsWithExpression(Object object) throws DumbException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            if (value == null || !value.startsWith(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

}
