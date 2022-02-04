package br.edu.mcesar.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.pages.login.LoginPO;

public class SignUpPO extends LoginPO {

	@FindBy(css = "input[placeholder='Confirm Password']")
	WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement registerButton;

	@FindBy(xpath = "//button[normalize-space()='New User? Register here!']")
	WebElement signUpLink;

	public SignUpPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
