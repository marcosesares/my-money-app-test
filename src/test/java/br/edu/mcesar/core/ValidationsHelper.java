package br.edu.mcesar.core;

public class ValidationsHelper {
	
	public ValidationsHelper() {
	}

	public String getDisplayedValidation(String name) {
        return name + " should be displayed.";
    }

	public String getEqualityValidation(String actualValue, String expectedValue, String name) {
		return "Field name - " + name + " : " + actualValue + " should be equal to " + expectedValue;
	}
	
	public String getFieldContainsValidation(String actualValue, String expectedValue, String name) {
		return "Field name - " + name + " : " + actualValue + " should contain " + expectedValue;
	}
	
	public String getFieldShouldHaveValueValidation(String fieldLabel, String value, String name) {
        return this.getFieldValueValidation(fieldLabel, value, name);
    }

	public String getFieldValueValidation(String fieldLabel, String value, String status) {
        return "Field " + fieldLabel + " should " + status + "} have value as " + value;
    }

    public String getStringEqualTo(String name, String actualValue, String expectedValue) {
		return "Field name - " + name + " : " + actualValue + " should be " + expectedValue;
	}
	
	public String getStringToContain(String name, String actualValue, String expectedValue) {
		return "Field name - " + name + " : " + actualValue + " should contain " + expectedValue;
	}
}