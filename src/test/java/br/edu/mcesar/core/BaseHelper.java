package br.edu.mcesar.core;

import static br.edu.mcesar.core.BasePOConstants.APP_LOGO;
import static br.edu.mcesar.core.Constants.APPLICATION_PROPERTIES;
import static br.edu.mcesar.core.Constants.BASE_URL;

import java.util.Properties;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.edu.mcesar.core.html.TextboxHelper;
import br.edu.mcesar.core.logger.StepLogger;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class BaseHelper {

	static Properties properties = PropertiesUtil.getInstance().getProperties(APPLICATION_PROPERTIES);
	protected WebDriver driver;
	private BasePO po;
	private ExpectationHelper expectationHelper;
	private WaitHelper waitHelper;
	private ElementHelper elementHelper;

	public BaseHelper(WebDriver webDriver) {
		driver = webDriver;
		this.po = new BasePO(webDriver);
		waitHelper = new WaitHelper(driver);
		elementHelper = new ElementHelper(driver);
		this.expectationHelper = new ExpectationHelper(webDriver);
	}

	public void openURL(WebDriver driver) {
		StepLogger.subStep("Open " + properties.getProperty(BASE_URL) + " in " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + " Browser.");
		driver.get(properties.getProperty(BASE_URL));
	}

	public void waitForElementToBeDisplayed(WebElement targetElement) {
		waitHelper.waitForElementToBeDisplayed(targetElement);
	}

	public void verifyDisplayedStatus(WebElement targetElement, String elementName) {
		expectationHelper.verifyDisplayedStatus(targetElement, elementName);
	}
	
	public void verifyElementTextEqualTo(WebElement targetElement, String expectedText, String elementName) {
		expectationHelper.verifyElementTextEqualTo(targetElement, expectedText, elementName);
	}
	
	public void verifyValue(WebElement targetElement, String expectedText, String elementName) {
		expectationHelper.verifyValue(targetElement, expectedText, elementName);
	}
	
	public void verifyAppLogoDisplayedStatus() {
		verifyDisplayedStatus(po.getAppLogo(), APP_LOGO);
	}

	public void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getTextboxValue(WebElement element) {
		return TextboxHelper.getAttributeValue(element, "value");
	}

    public void scrollToElement(WebElement element) {
        elementHelper.scrollToElement(element);
    }

}