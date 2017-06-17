package com.ireul.azuki;

import com.ireul.azuki.expressions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a static method to create a {@link Expression} with given Map
 *
 * @author Ryan Wade
 */
@SuppressWarnings("WeakerAccess")
public class Azuki {

    private static final HashMap<String, Class<? extends Expression>> EXPRESSIONS = new HashMap<>();

    static {
        register("all", AllExpression.class);
        register("and", AllExpression.class);
        register("any", AnyExpression.class);
        register("or", AnyExpression.class);
        register("none", NoneExpression.class);
        register("not", NotExpression.class);
        register("equals", EqualsExpression.class);
        register("equalsIgnoreCase", EqualsIgnoreCaseExpression.class);
        register("startsWith", StartsWithExpression.class);
        register("startsWithIgnoreCase", StartsWithIgnoreCaseExpression.class);
        register("endsWith", EndsWithExpression.class);
        register("endsWithIgnoreCase", EndsWithIgnoreCaseExpression.class);
        register("contains", ContainsExpression.class);
        register("containsIgnoreCase", ContainsIgnoreCaseExpression.class);
        register("pattern", RegexExpression.class);
        register("regex", RegexExpression.class);
        register("exists", ExistsExpression.class);
    }

    /**
     * Register a Expression class with name
     *
     * @param name            name of expression
     * @param expressionClass expression class
     */
    public static void register(String name, Class<? extends Expression> expressionClass) {
        EXPRESSIONS.put(name, expressionClass);
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
