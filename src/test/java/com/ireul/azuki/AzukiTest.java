package com.ireul.azuki;

import com.ireul.azuki.expressions.base.Expression;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * @author Ryan Wade
 */
public class AzukiTest {

    @Test
    public void testBuild() throws AzukiException {
        HashMap<String, Object> root = new HashMap<>();
        HashMap<String, String> equals = new HashMap<>();
        equals.put("Hello", "World");
        root.put("equals", equals);
        Expression expression = Azuki.build(root);
        assertTrue(expression.validate(equals));
    }

}