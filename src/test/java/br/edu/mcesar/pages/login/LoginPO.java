package br.edu.mcesar.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class LoginPO extends BasePO {

	@FindBy(css = "input[placeholder='Name']")
	private WebElement nameTextField;
	
	@FindBy(css = "input[placeholder='Email']")
	private WebElement emailTextField;

	@FindBy(css = "input[placeholder='Password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//button[normalize-space()='Already registered? Login here!']")
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
