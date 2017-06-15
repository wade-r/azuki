package com.ireul.dumb;

import com.ireul.dumb.expressions.base.Expression;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * @author Ryan Wade
 */
public class DumbTest {

    @Test
    public void testBuild() throws DumbException {
        HashMap<String, Object> root = new HashMap<>();
        HashMap<String, String> equals = new HashMap<>();
        equals.put("Hello", "World");
        root.put("equals", equals);
        Expression expression = Dumb.build(root);
        assertTrue(expression.validate(equals));
    }

}