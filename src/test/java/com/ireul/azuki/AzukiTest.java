package com.ireul.azuki;

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
        for (int i = 0; ; i++) {
            String filename = "test-" + (1000 + i) + ".yml";
            InputStream inputStream = AzukiTest.class.getResourceAsStream("/" + filename);
            if (inputStream == null) break;
            System.out.print("Running file: " + filename + " [");
            TestModel model = new Yaml().loadAs(inputStream, TestModel.class);
            Expression expression = Azuki.build(model.getMatch());
            int index = 0;
            for (TestModel.TestModelValue value : model.getValues()) {
                if (expression.validate(value.getValue()) == value.getResult()) {
                    System.out.print(".");
                } else {
                    System.out.print("x");
                }
                index++;
                assertEquals("Test Failed: " + filename + " #" + index,
                        expression.validate(value.getValue()), value.getResult());
            }
            System.out.print("]\n");
        }
    }

}