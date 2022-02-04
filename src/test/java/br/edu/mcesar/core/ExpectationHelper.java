package br.edu.mcesar.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.edu.mcesar.core.logger.StepLogger;

public class ExpectationHelper {

	private WaitHelper waitHelper;
	private ValidationsHelper validationsHelper;

	public ExpectationHelper(WebDriver driver) {
		waitHelper = new WaitHelper(driver);
		validationsHelper = new ValidationsHelper();
	}

	public void verifyDisplayedStatus(WebElement targetElement) {
        WebElement elementToBeDisplayed = waitHelper.waitForElementToBeDisplayed(targetElement);
        String elementText = elementToBeDisplayed.getText();
		String tagName = elementToBeDisplayed.getTagName();
		String message = validationsHelper.getDisplayedValidation(elementText != null ? elementText : tagName);
        StepLogger.subVerification(message);
		Assertions.assertSame(targetElement, elementToBeDisplayed, message);
    }
}
