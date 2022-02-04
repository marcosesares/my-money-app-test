package br.edu.mcesar.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class LoginPO extends BasePO {

	@FindBy(css = "input[placeholder='Name']")
	WebElement nameTextField;
	
	@FindBy(css = "input[placeholder='Email']")
	WebElement emailTextField;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//button[normalize-space()='Already registered? Login here!']")
	WebElement loginLink;

	public LoginPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
