package br.edu.mcesar.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.edu.mcesar.core.html.TextboxHelper;
import br.edu.mcesar.core.logger.StepLogger;

public class ExpectationHelper {

	private WaitHelper waitHelper;
	private ValidationsHelper validationsHelper;

	public ExpectationHelper(WebDriver driver) {
		waitHelper = new WaitHelper(driver);
		validationsHelper = new ValidationsHelper();
	}

	public void verifyValue(WebElement targetElement, String expectedText, String elementName) {
        WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
        String actualText = TextboxHelper.getAttributeValue(elementToBeDisplayed, "value");
        elementName = elementName != null ? elementName : actualText;
        String message = validationsHelper.getFieldShouldHaveValueValidation(elementName, actualText, expectedText);
        StepLogger.subVerification(message, targetElement);
		Assertions.assertEquals(expectedText, actualText, message);
    }
	
	public void verifyElementTextEqualTo(WebElement targetElement, String expectedText, String elementName) {
		WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
		String actualText = elementToBeDisplayed.getText();
		elementName = elementName != null ? elementName : actualText;
		String message = validationsHelper.getStringEqualTo(elementName, actualText, expectedText);
		StepLogger.subVerification(message, targetElement);
		Assertions.assertEquals(expectedText, actualText, message);
	}
	
	public void verifyDisplayedStatus(WebElement targetElement) {
		WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
		String elementText = elementToBeDisplayed.getText();
		String tagName = elementToBeDisplayed.getTagName();
		String message = validationsHelper.getDisplayedValidation(elementText != null ? elementText : tagName);
		StepLogger.subVerification(message, targetElement);
		Assertions.assertSame(targetElement, elementToBeDisplayed, message);
	}
}
