package br.edu.mcesar.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	
	protected WebDriver driver;

	@FindBy(css = ".content-header h1")
	private WebElement headerSectionLabel;

	@FindBy(css = ".login-logo")
	private WebElement appLogo;
	
	@FindBy(css = ".login-box-msg")
	private WebElement loginBoxMsg;
	
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	private WebElement dashboardMenuLink;
	
	@FindBy(xpath = "//a[span[normalize-space()='Register']]")
	private WebElement registerMenuLink;
	
	@FindBy(xpath = "//a[span[normalize-space()='Payment cycles']]")
	private WebElement paymentCyclesMenuLink;
	
	protected BasePO(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderSectionLabel() {
		return headerSectionLabel;
	}

	public WebElement getAppLogo() {
		return appLogo;
	}

	public WebElement getLoginBoxMsg() {
		return loginBoxMsg;
	}

	public WebElement getDashboardMenuLink() {
		return dashboardMenuLink;
	}

	public WebElement getRegisterMenuLink() {
		return registerMenuLink;
	}

	public WebElement getPaymentCyclesMenuLink() {
		return paymentCyclesMenuLink;
	}
}
