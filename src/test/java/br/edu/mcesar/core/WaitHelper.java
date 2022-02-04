package br.edu.mcesar.core;

import static br.edu.mcesar.core.CoreConstants.DEFAULT_TIMEOUT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private final Duration TIMEOUT = Duration.ofMillis(DEFAULT_TIMEOUT.getValor());
	private WebDriver driver;

	public WaitHelper(WebDriver webDriver) {
		driver = webDriver;
	}

	public WebElement waitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
