package com.ireul.azuki;

import com.ireul.azuki.expressions.base.Expression;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Ryan Wade
 */
public class AzukiTest {

    @Test
    public void testAzuki() throws AzukiException {
        for (int i = 0; i < 1; i++) {
            String filename = "test-" + (1000 + i) + ".yml";
            System.out.print("running file: " + filename + " [");
            InputStream inputStream = AzukiTest.class.getResourceAsStream("/" + filename);
            TestModel model = new Yaml().loadAs(inputStream, TestModel.class);
            Expression expression = Azuki.build(model.getMatch());
            for (TestModel.TestModelValue value : model.getValues()) {
                System.out.print(".");
                assertEquals(expression.validate(value.getValue()), value.getResult() == 1);
            }
            System.out.print("]\n");
        }
    }

}