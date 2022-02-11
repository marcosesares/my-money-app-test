package br.edu.mcesar.pages.signup;

import static br.edu.mcesar.pages.signup.SignUpPOConstants.BUTTON_NEW_USER_REGISTER_HERE;
import static br.edu.mcesar.pages.signup.SignUpPOConstants.BUTTON_REGISTER;
import static br.edu.mcesar.pages.signup.SignUpPOConstants.INPUT_PLACEHOLDER_CONFIRM_PASSWORD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.pages.login.LoginPO;

public class SignUpPO extends LoginPO {

	@FindBy(css = INPUT_PLACEHOLDER_CONFIRM_PASSWORD)
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = BUTTON_REGISTER)
	private WebElement registerButton;

	@FindBy(xpath = BUTTON_NEW_USER_REGISTER_HERE)
	private WebElement signUpLink;

	public SignUpPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}

}
