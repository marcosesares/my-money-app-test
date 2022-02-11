package br.edu.mcesar.pages.dashboard;

import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.LABEL_CONSOLIDATED;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.VALUE_CONSOLIDATED;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.LABEL_TOTAL_CREDITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.VALUE_TOTAL_CREDITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.LABEL_TOTAL_DEBITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.VALUE_TOTAL_DEBITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.USERNAME_SELECTOR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class DashboardPO extends BasePO {

	@FindBy(xpath = VALUE_TOTAL_CREDITS)
	private WebElement totalCreditsValue;
	
	@FindBy(xpath = VALUE_TOTAL_DEBITS)
	private WebElement totalDebitsValue;
	
	@FindBy(xpath = VALUE_CONSOLIDATED)
	private WebElement consolidatedValue;
	
	@FindBy(xpath = LABEL_TOTAL_CREDITS)
	private WebElement totalCreditsLabel;
	
	@FindBy(xpath = LABEL_TOTAL_DEBITS)
	private WebElement totalDebitsLabel;
	
	@FindBy(xpath = LABEL_CONSOLIDATED)
	private WebElement consolidatedLabel;

	@FindBy(css = USERNAME_SELECTOR)
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
