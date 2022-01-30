package br.edu.mcesar.tests;

import org.junit.Before;
import org.junit.Test;

import br.edu.mcesar.core.BaseTest;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;
import io.qameta.allure.Feature;

public class LoginTest extends BaseTest {

	private User user;
	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;

	public LoginTest() {
		loginHelper = LoginHelper.getInstance();
		dashboardHelper = DashboardHelper.getInstance();
		user = new User("Marcos César", "marcosesares@gmail.com", "a2@MyMoney211");
	}

	@Before
	public void initialize() {
		StepLogger.preCondition("Navigate to My Money App.");
		loginHelper.openMyMoneyApp();
		loginHelper.verifyAppLogoDisplayedStatus();
	}

	@Test
	@Feature("LoginTest")
	public void loginTest() throws InterruptedException {
		StepLogger.setCaseId(1001);
		StepLogger.stepId(1);
		StepLogger.step("Login to My Money App.");
		loginHelper.enterLoginInformation(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}
}
