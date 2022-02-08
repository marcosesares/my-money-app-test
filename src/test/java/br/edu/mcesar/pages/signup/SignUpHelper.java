package br.edu.mcesar.pages.signup;

import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;

public class SignUpHelper extends BaseHelper {

	private SignUpPO po;
	private LoginHelper loginHelper;

	public SignUpHelper(WebDriver driver) {
		super(driver);
		loginHelper = new LoginHelper(driver);
		po = new SignUpPO(driver);
	}

	public void fillSignUpFormAndClickRegisterButton(User user) {
		fillSignUpForm(user);
		StepLogger.subStep("Click the Register Button.", po.getRegisterButton());
		po.getRegisterButton().click();
	}

	private void fillSignUpForm(User user) {
		StepLogger.subStep("Click the New User? Register here! Link.", po.getSignUpLink());
		po.getSignUpLink().click();
		loginHelper.fillNameTextfield(user.getName());
		loginHelper.fillLoginForm(user);
		StepLogger.subStep("Type the user confirmation password.", po.getConfirmPasswordTextField());
		po.getConfirmPasswordTextField().clear();
		po.getConfirmPasswordTextField().sendKeys(user.getPassword());
	}
}
