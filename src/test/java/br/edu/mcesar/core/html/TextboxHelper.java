package br.edu.mcesar.core.html;

import org.openqa.selenium.WebElement;

public class TextboxHelper {

	private TextboxHelper() {}

	public static String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public static Boolean hasValue(WebElement element, String value) {
		String attributeValue = element.getAttribute("value");
		return value.equals(attributeValue);
	}
	
}
