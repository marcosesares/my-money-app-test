package br.edu.mcesar.tests.smoke;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.core.providers.UserProvider;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.pages.signup.SignUpHelper;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Feature;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("smoke")
@ExtendWith(SeleniumJupiter.class)
public class SignUpTest {

	private SignUpHelper signUpHelper;
	private DashboardHelper dashboardHelper;

	@BeforeEach
	private void setUp( WebDriver driver) {
		dashboardHelper = new DashboardHelper(driver);
		signUpHelper = new SignUpHelper(driver);
		StepLogger.setCaseId(1002, driver);
		StepLogger.stepId(1);
		StepLogger.preCondition("Navigate to My Money App.");
		signUpHelper.openURL(driver);
		StepLogger.verification("Verify My Money App logo is displayed.");
		signUpHelper.verifyAppLogoDisplayedStatus();
	}

	@Feature("Sign Up")
	@ParameterizedTest
	@ArgumentsSource(value = UserProvider.class)
	void signUpTest(User user) throws InterruptedException {
		StepLogger.stepId(1);
		StepLogger.step("Sign up to My Money App.");
		signUpHelper.fillSignUpFormAndClickRegisterButton(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
		StepLogger.verification("Verify User name is displayed.");
		dashboardHelper.verifyUserNameLabelDisplayedStatus();
	}
	
}
