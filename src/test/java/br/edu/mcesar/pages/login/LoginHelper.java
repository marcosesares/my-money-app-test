package br.edu.mcesar.pages.login;

import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.models.User;

public class LoginHelper extends BaseHelper {

	private LoginPO po;
	private DashboardHelper dashboardHelper;

	public LoginHelper(WebDriver driver) {
		super(driver);
		po = new LoginPO(driver);
	}

	public void fillLoginFormAndClickLoginButton(User user) {
		fillLoginForm(user);
		StepLogger.subStep("Click the Login Button.", po.getLoginButton());
		po.getLoginButton().click();
	}

	public void loginToMyMoneyApp(User user) {
		fillLoginFormAndClickLoginButton(user);
		StepLogger.subVerification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}

	public User openMyMoneyApp(WebDriver driver) {
		User user = new User("Marcos Cesar", "marcosesares@gmail.com", "a2@MyMoney211");
		dashboardHelper = new DashboardHelper(driver);
		openURL(driver);
		StepLogger.verification("Verify My Money App logo is displayed.");
		verifyAppLogoDisplayedStatus();
		return user;
	}

	public void fillLoginForm(User user) {
		StepLogger.subStep("Type the user email.", po.getEmailTextField());
		po.getEmailTextField().clear();
		po.getEmailTextField().sendKeys(user.getEmail());
		StepLogger.subStep("Type the user password.", po.getPasswordTextField());
		po.getPasswordTextField().clear();
		po.getPasswordTextField().sendKeys(user.getPassword());
	}

	public void fillNameTextfield(String name) {
		StepLogger.subStep("Type the user name.", po.getNameTextField());
		po.getNameTextField().clear();
		po.getNameTextField().sendKeys(name);
	}
}
