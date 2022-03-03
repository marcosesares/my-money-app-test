package br.edu.mcesar.core;

import static br.edu.mcesar.core.BasePOConstants.CONTENT_HEADER;
import static br.edu.mcesar.core.BasePOConstants.DASHBOARD_LABEL;
import static br.edu.mcesar.core.BasePOConstants.LOGIN_BOX_MSG;
import static br.edu.mcesar.core.BasePOConstants.LOGIN_LOGO;
import static br.edu.mcesar.core.BasePOConstants.PAYMENT_CYCLES_LABEL;
import static br.edu.mcesar.core.BasePOConstants.REGISTER_LABEL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	
	private WebDriver driver;

	@FindBy(css = CONTENT_HEADER)
	private WebElement headerSectionLabel;

	@FindBy(css = LOGIN_LOGO)
	private WebElement appLogo;
	
	@FindBy(css = LOGIN_BOX_MSG)
	private WebElement loginBoxMsg;
	
	@FindBy(xpath = DASHBOARD_LABEL)
	private WebElement dashboardMenuLink;
	
	@FindBy(xpath = REGISTER_LABEL)
	private WebElement registerMenuLink;
	
	@FindBy(xpath = PAYMENT_CYCLES_LABEL)
	private WebElement paymentCyclesMenuLink;
	
	protected BasePO(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	protected WebElement findElementByxPath(String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression));
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
