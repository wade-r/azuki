package com.ireul.azuki;

import com.ireul.azuki.expressions.base.Expression;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This class provides a static method to create a {@link Expression} with given Map
 *
 * @author Ryan Wade
 */
public class Azuki {

    /**
     * Create an {@link Expression} from given {@code Map} source
     *
     * @param object source of expression
     * @return {@link Expression}
     * @throws AzukiException if error occurred
     */
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
        String key = (String) entry.getKey();
        String name = key.substring(0, 1).toUpperCase() + key.substring(1);
        String className = "com.ireul.azuki.expressions." + name + "Expression";
        try {
            return (Expression) Class.forName(className).getConstructor(Object.class).newInstance(entry.getValue());
        } catch (ClassNotFoundException e) {
            throw new AzukiException("Unsupported expression: " + key);
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
