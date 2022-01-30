package br.edu.mcesar.core;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import br.edu.mcesar.core.logger.StepLogger;

public class ExpectationHelper {

	private ExpectationHelper() {
	}

    public static void verifyDisplayedStatus(WebElement targetElement) {
        WebElement elementToBeDisplayed = WaitHelper.waitForElementToBeDisplayed(targetElement);
        String elementText = elementToBeDisplayed.getText();
		String tagName = elementToBeDisplayed.getTagName();
		String message = ValidationsHelper.getDisplayedValidation(elementText != null ? elementText : tagName);
        StepLogger.subVerification(message);
		Assert.assertSame(message, targetElement, elementToBeDisplayed);
    }
}
