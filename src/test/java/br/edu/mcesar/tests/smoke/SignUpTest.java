package br.edu.mcesar.tests.smoke;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.Constants;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.pages.signup.SignUpHelper;
import io.github.bonigarcia.seljup.Arguments;
//import io.qameta.allure.Feature;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Feature;

@Tag("smoke")
@ExtendWith(SeleniumJupiter.class)
public class SignUpTest {

	private SignUpHelper signUpHelper;
	private DashboardHelper dashboardHelper;

	@BeforeEach
	private void setUp(@Arguments("--headless") ChromeDriver driver) {
		dashboardHelper = new DashboardHelper(driver);
		signUpHelper = new SignUpHelper(driver);
		StepLogger.setCaseId(1002, driver);
		StepLogger.preCondition("Navigate to My Money App.");
		signUpHelper.openURL(driver);
		StepLogger.verification("Verify My Money App logo is displayed.");
		signUpHelper.verifyAppLogoDisplayedStatus();
	}

	@Test
	@Feature("Sign Up")
	void signUpTest() throws InterruptedException {
		Faker faker = new Faker();
		User user = new User(faker.artist().name(), faker.regexify(Constants.EMAIL_REGEX), faker.regexify(Constants.PASSWORD_REGEX));

		StepLogger.stepId(1);
		StepLogger.step("Sign up to My Money App.");
		signUpHelper.fillSignUpFormAndClickRegisterButton(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
		StepLogger.verification("Verify User name is displayed.");
		dashboardHelper.verifyUserNameLabelDisplayedStatus();
	}
}
