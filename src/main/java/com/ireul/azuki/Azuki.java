package com.ireul.azuki;

import com.ireul.azuki.expressions.*;
import com.ireul.azuki.expressions.base.Expression;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a static method to create a {@link Expression} with given Map
 *
 * @author Ryan Wade
 */
public class Azuki {

    private static final HashMap<String, Class<? extends Expression>> EXPRESSIONS = new HashMap<>();

    static {
        EXPRESSIONS.put("all", AllExpression.class);
        EXPRESSIONS.put("and", AllExpression.class);
        EXPRESSIONS.put("any", AnyExpression.class);
        EXPRESSIONS.put("or", AnyExpression.class);
        EXPRESSIONS.put("none", NoneExpression.class);
        EXPRESSIONS.put("not", NotExpression.class);
        EXPRESSIONS.put("equals", EqualsExpression.class);
        EXPRESSIONS.put("equalsIgnoreCase", EqualsIgnoreCaseExpression.class);
        EXPRESSIONS.put("startsWith", StartsWithExpression.class);
        EXPRESSIONS.put("startsWithIgnoreCase", StartsWithIgnoreCaseExpression.class);
        EXPRESSIONS.put("endsWith", EndsWithExpression.class);
        EXPRESSIONS.put("endsWithIgnoreCase", EndsWithIgnoreCaseExpression.class);
        EXPRESSIONS.put("contains", ContainsExpression.class);
        EXPRESSIONS.put("containsIgnoreCase", ContainsIgnoreCaseExpression.class);
        EXPRESSIONS.put("pattern", PatternExpression.class);
        EXPRESSIONS.put("regex", PatternExpression.class);
        EXPRESSIONS.put("exists", ExistsExpression.class);
    }

    /**
     * Create an {@link Expression} from given {@code Map} source
     *
     * @param object source of expression
     * @return {@link Expression}
     * @throws AzukiException if error occurred
     */
    @SuppressWarnings("unchecked")
    public static Expression build(Object object) throws AzukiException {
        if (object == null) {
            throw new AzukiException(new IllegalArgumentException());
        }
        if (!(object instanceof Map)) {
            throw new AzukiException("build must be invoked on a Map object");
        }
        Map<?, ?> map = (Map) object;
        if (map.size() != 1) {
            throw new AzukiException("Map must have and only have one expression");
        }
        Map.Entry<?, ?> entry = map.entrySet().iterator().next();
        if (!(entry.getKey() instanceof String)) {
            throw new AzukiException("key must be string");
        }
        Class aClass = EXPRESSIONS.get(entry.getKey());
        if (aClass == null) {
            throw new AzukiException("Expression not supported: " + entry.getKey());
        }
        try {
            return (Expression) aClass.getConstructor(Object.class).newInstance(entry.getValue());
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AzukiException) {
                throw (AzukiException) e.getCause();
            } else {
                throw new AzukiException(e);
            }
        } catch (Throwable e) {
            throw new AzukiException(e);
        }
    }

}
