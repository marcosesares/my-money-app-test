package br.edu.mcesar.tests.smoke;

import java.util.Properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.PropertiesUtil;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.tests.BaseTest;
import io.qameta.allure.Feature;

import static br.edu.mcesar.core.Constants.USER_PROPERTIES;
import static br.edu.mcesar.core.Constants.NAME;
import static br.edu.mcesar.core.Constants.EMAIL;
import static br.edu.mcesar.core.Constants.PASSWORD;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("e2e")
public class LoginTest extends BaseTest {

	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;

	@TestTemplate
	@Feature("Login")
	public void loginTest( WebDriver driver) throws InterruptedException {
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
		loginHelper.fillLoginFormAndClickLoginButton(getUser());
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}

	private User getUser() {
		Properties properties = PropertiesUtil.getInstance().getProperties(USER_PROPERTIES);
		String userName = properties.getProperty(NAME);
		String userEmail = properties.getProperty(EMAIL);
		String userPassword = properties.getProperty(PASSWORD);
		User user = new User(userName, userEmail, userPassword);
		return user;
	}

}
