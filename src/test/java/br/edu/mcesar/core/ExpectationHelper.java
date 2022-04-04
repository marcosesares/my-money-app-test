package br.edu.mcesar.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.edu.mcesar.core.html.TextboxHelper;
import br.edu.mcesar.core.logger.StepLogger;

public class ExpectationHelper {

	private WaitHelper waitHelper;

	public ExpectationHelper(WebDriver driver) {
		waitHelper = new WaitHelper(driver);
	}

	public static void verifyNotEmpty(String expectedText, String elementName) {
		String message = ValidationsHelper.getFieldShouldNotBeEmptyValidation(elementName, expectedText);
		StepLogger.subVerification(message);
		Assertions.assertNotNull(expectedText, message);
		Assertions.assertTrue(expectedText.length() > 1, message);
	}

	public static void verifyValue(String expectedText, String actualText, String elementName) {
		String message = ValidationsHelper.getFieldShouldHaveValueValidation(elementName, actualText, expectedText);
		StepLogger.subVerification(message);
		Assertions.assertEquals(expectedText, actualText, message);
	}

	public void verifyValue(WebElement targetElement, String expectedText, String elementName) {
		WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
		String actualText = TextboxHelper.getAttributeValue(elementToBeDisplayed, "value");
		elementName = elementName != null ? elementName : actualText;
		String message = ValidationsHelper.getFieldShouldHaveValueValidation(elementName, actualText, expectedText);
		StepLogger.subVerification(message, targetElement);
		Assertions.assertEquals(expectedText, actualText, message);
	}

	public void verifyElementTextEqualTo(WebElement targetElement, String expectedText, String elementName) {
		WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
		String actualText = elementToBeDisplayed.getText();
		elementName = elementName != null ? elementName : actualText;
		String message = ValidationsHelper.getStringEqualTo(elementName, actualText, expectedText);
		StepLogger.subVerification(message, targetElement);
		Assertions.assertEquals(expectedText, actualText, message);
	}

	public void verifyDisplayedStatus(WebElement targetElement, String elementName) {
		WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
		String elementText = elementToBeDisplayed.getText();
		String tagName = elementToBeDisplayed.getTagName();
		elementName = elementName != null ? elementName : elementText != null ? elementText : tagName;
		String message = ValidationsHelper.getDisplayedValidation(elementName);
		StepLogger.subVerification(message, targetElement);
		Assertions.assertSame(targetElement, elementToBeDisplayed, message);
	}
}
