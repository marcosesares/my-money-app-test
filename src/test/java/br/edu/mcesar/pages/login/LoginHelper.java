package br.edu.mcesar.pages.login;

import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.models.User;

public class LoginHelper extends BaseHelper {

	private LoginPO po;

	public LoginHelper(WebDriver driver) {
		super(driver);
		po = new LoginPO(driver);
	}

	public void fillLoginFormAndClickLoginButton(User user) {
		fillLoginForm(user);
		StepLogger.subStep("Click the Login Button.");
		po.loginButton.click();
	}

	public void fillLoginForm(User user) {
		StepLogger.subStep("Type the user email.");
		po.emailTextField.clear();
		po.emailTextField.sendKeys(user.getEmail());
		StepLogger.subStep("Type the user password.");
		po.passwordTextField.clear();
		po.passwordTextField.sendKeys(user.getPassword());
	}

	public void fillNameTextfield(String name) {
		StepLogger.subStep("Type the user name.");
		po.nameTextField.clear();
		po.nameTextField.sendKeys(name);
	}
}
