package com.ireul.dumb;

import com.ireul.dumb.expressions.base.Expression;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This class provides a static method to create a {@link Expression} with given Map
 *
 * @author Ryan Wade
 */
public class Dumb {

    /**
     * Create an {@link Expression} from given {@code Map} source
     *
     * @param object source of expression
     * @return {@link Expression}
     * @throws DumbException if error occurred
     */
    public static Expression build(Object object) throws DumbException {
        if (object == null) {
            throw new DumbException(new IllegalArgumentException());
        }
        if (!(object instanceof Map)) {
            throw new DumbException("build must be invoked on a Map object");
        }
        Map<?, ?> map = (Map) object;
        if (map.size() != 1) {
            throw new DumbException("Map must have and only have one expression");
        }
        Map.Entry<?, ?> entry = map.entrySet().iterator().next();
        if (!(entry.getKey() instanceof String)) {
            throw new DumbException("key must be string");
        }
        String key = (String) entry.getKey();
        String name = key.substring(0, 1).toUpperCase() + key.substring(1);
        String className = "com.ireul.dumb.expressions." + name + "Expression";
        try {
            return (Expression) Class.forName(className).getConstructor(Object.class).newInstance(entry.getValue());
        } catch (ClassNotFoundException e) {
            throw new DumbException("Unsupported expression: " + key);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof DumbException) {
                throw (DumbException) e.getCause();
            } else {
                throw new DumbException(e);
            }
        } catch (Throwable e) {
            throw new DumbException(e);
        }
    }

}
