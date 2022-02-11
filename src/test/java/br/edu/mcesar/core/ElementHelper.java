package br.edu.mcesar.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.edu.mcesar.core.logger.StepLogger;

public class ElementHelper {

	protected WebDriver driver;

    public ElementHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void scrollToElement(WebElement element) {
        StepLogger.subStep("Scroll to element: ${target.name}");
        String scrollIntoView = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scrollIntoView, new Object[] { element });
    }

}
