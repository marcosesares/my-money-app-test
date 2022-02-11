package br.edu.mcesar.tests.smoke;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.tests.BaseTest;
import io.github.bonigarcia.seljup.Arguments;
import io.qameta.allure.Feature;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("smoke")
public class LoginTest extends BaseTest {

	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;

	@TestTemplate
	@Feature("Login")
	public void loginTest( WebDriver driver) throws InterruptedException {
		User user = new User("Marcos Cesar", "marcosesares@gmail.com", "a2@MyMoney211");
		dashboardHelper = new DashboardHelper(driver);
		loginHelper = new LoginHelper(driver);
		StepLogger.setCaseId(1001, driver);

		StepLogger.stepId(1);
		StepLogger.step("Navigate to My Money App.");
		loginHelper.openURL(driver);
		StepLogger.verification("Verify My Money App logo is displayed.");
		loginHelper.verifyAppLogoDisplayedStatus();

		StepLogger.stepId(2);
		StepLogger.step("Login to My Money App.");
		loginHelper.fillLoginFormAndClickLoginButton(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}

}
