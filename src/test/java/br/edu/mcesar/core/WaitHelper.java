package br.edu.mcesar.core;

import static br.edu.mcesar.core.CoreConstants.DEFAULT_TIMEOUT;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.DefaultDecorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper extends WebDriverDecorator {

	private final Duration TIMEOUT = Duration.ofMillis(DEFAULT_TIMEOUT.getValor());
	private WebDriver driver;
	private WebDriverWait wait;

	public WaitHelper(WebDriver webDriver) {
		driver = webDriver;
	}

	public WebElement waitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
    public Decorated<WebDriver> createDecorated(WebDriver driver) {
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return super.createDecorated(driver);
    }
    @Override
    public Decorated<WebElement> createDecorated(WebElement original) {
      return new DefaultDecorated<WebElement>(original, this) {
        @Override
        public void beforeCall(Method method, Object[] args) {
          String methodName = method.getName();
          if ("click".equals(methodName) || "sendKeys".equals(methodName)) {
            wait.until(d -> getOriginal().isDisplayed());
          }
        }
      };
    }
   }
