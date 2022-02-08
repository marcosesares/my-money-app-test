package br.edu.mcesar.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.pages.login.LoginPO;

public class SignUpPO extends LoginPO {

	@FindBy(css = "input[placeholder='Confirm Password']")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Register']")
	private WebElement registerButton;

	@FindBy(xpath = "//button[normalize-space()='New User? Register here!']")
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
