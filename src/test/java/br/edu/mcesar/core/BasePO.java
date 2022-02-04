package br.edu.mcesar.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	
	private WebDriver driver;

	@FindBy(css = ".login-logo")
	WebElement appLogo;
	
	@FindBy(css = ".login-box-msg")
	WebElement loginBoxMsg;
	
	protected BasePO(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver, this);
	}
}
