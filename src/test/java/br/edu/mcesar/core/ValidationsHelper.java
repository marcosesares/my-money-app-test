package br.edu.mcesar.core;

public abstract class ValidationsHelper {
	
	public static String getDisplayedValidation(String name) {
        return name + " should be displayed.";
    }

	public static String getEqualityValidation(String actualValue, String expectedValue, String name) {
		return "Field name - " + name + " : " + actualValue + " should be equal to " + expectedValue;
	}
	
	public static String getFieldContainsValidation(String actualValue, String expectedValue, String name) {
		return "Field name - " + name + " : " + actualValue + " should contain " + expectedValue;
	}
	
	public static String getFieldShouldNotBeEmptyValidation(String actualValue, String name) {
		return "Field name - " + name + " : " + actualValue + " should not be empty";
	}
	
	public static String getFieldShouldHaveValueValidation(String fieldLabel, String value, String name) {
        return getFieldValueValidation(fieldLabel, value, name);
    }

	public static String getFieldValueValidation(String fieldLabel, String value, String status) {
        return "Field " + fieldLabel + " should " + status + "} have value as " + value;
    }

	public static String getStringEqualTo(String name, String actualValue, String expectedValue) {
		return "Field name - " + name + " : " + actualValue + " should be " + expectedValue;
	}
	
	public static String getStringToContain(String name, String actualValue, String expectedValue) {
		return "Field name - " + name + " : " + actualValue + " should contain " + expectedValue;
	}
}