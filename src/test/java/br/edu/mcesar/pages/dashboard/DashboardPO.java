package br.edu.mcesar.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class DashboardPO extends BasePO {

	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Total Credits']/parent::div/h3")
	private WebElement totalCreditsValue;
	
	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Total Debits']/parent::div/h3")
	private WebElement totalDebitsValue;
	
	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Consolidated']/parent::div/h3")
	private WebElement consolidatedValue;
	
	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Total Credits']")
	private WebElement totalCreditsLabel;
	
	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Total Debits']")
	private WebElement totalDebitsLabel;
	
	@FindBy(xpath = "//div[contains(@class,'small-box')]//p[normalize-space()='Consolidated']")
	private WebElement consolidatedLabel;

	@FindBy(css = ".hidden-xs")
	private WebElement userNameLabel;

	protected DashboardPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getTotalCreditsValue() {
		return totalCreditsValue;
	}

	public WebElement getTotalDebitsValue() {
		return totalDebitsValue;
	}

	public WebElement getConsolidatedValue() {
		return consolidatedValue;
	}

	public WebElement getTotalCreditsLabel() {
		return totalCreditsLabel;
	}

	public WebElement getTotalDebitsLabel() {
		return totalDebitsLabel;
	}

	public WebElement getConsolidatedLabel() {
		return consolidatedLabel;
	}

	public WebElement getUserNameLabel() {
		return userNameLabel;
	}
}
