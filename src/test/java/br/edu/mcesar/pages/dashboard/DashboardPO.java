package br.edu.mcesar.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class DashboardPO extends BasePO {

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	WebElement dashboardSection;

	@FindBy(css = ".hidden-xs")
	WebElement userNameLabel;

	protected DashboardPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
