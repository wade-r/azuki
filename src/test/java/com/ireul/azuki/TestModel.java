package com.ireul.azuki;

import java.util.List;
import java.util.Map;

/**
 * @author Ryan Wade
 */
public class TestModel {

    public static class TestModelValue {

        private Map<String, String> value;

        private boolean result;

        public Map<String, String> getValue() {
            return value;
        }

        public void setValue(Map<String, String> value) {
            this.value = value;
        }

        public boolean getResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }
    }

    private Map<String, Object> match;

    private List<TestModelValue> values;

    public Map<String, Object> getMatch() {
        return match;
    }

    public void setMatch(Map<String, Object> match) {
        this.match = match;
    }

    public List<TestModelValue> getValues() {
        return values;
    }

    public void setValues(List<TestModelValue> values) {
        this.values = values;
    }

}
