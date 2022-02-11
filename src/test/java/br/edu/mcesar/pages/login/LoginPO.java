package br.edu.mcesar.pages.login;

import static br.edu.mcesar.pages.login.LoginPOConstants.BUTTON_ALREADY_REGISTERED;
import static br.edu.mcesar.pages.login.LoginPOConstants.BUTTON_LOGIN;
import static br.edu.mcesar.pages.login.LoginPOConstants.INPUT_PLACEHOLDER_EMAIL;
import static br.edu.mcesar.pages.login.LoginPOConstants.INPUT_PLACEHOLDER_NAME;
import static br.edu.mcesar.pages.login.LoginPOConstants.INPUT_PLACEHOLDER_PASSWORD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class LoginPO extends BasePO {

	@FindBy(css = INPUT_PLACEHOLDER_NAME)
	private WebElement nameTextField;
	
	@FindBy(css = INPUT_PLACEHOLDER_EMAIL)
	private WebElement emailTextField;

	@FindBy(css = INPUT_PLACEHOLDER_PASSWORD)
	private WebElement passwordTextField;
	
	@FindBy(xpath = BUTTON_LOGIN)
	private WebElement loginButton;

	@FindBy(xpath = BUTTON_ALREADY_REGISTERED)
	private WebElement loginLink;

	public LoginPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
}
