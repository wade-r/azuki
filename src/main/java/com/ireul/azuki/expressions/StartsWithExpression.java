package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.expressions.base.EvaluationExpression;

import java.util.Map;

/**
 * Created by ryan on 2017/6/16.
 */
public class StartsWithExpression extends EvaluationExpression {

    public StartsWithExpression(Object object) throws AzukiException {
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
