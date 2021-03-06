package br.edu.mcesar.tests.e2e;

import org.junit.jupiter.api.BeforeEach;
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
import io.qameta.allure.Feature;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("e2e")
public class DashboardTest extends BaseTest {

	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;
	private WebDriver driver;
	
	@BeforeEach
	void navigateToDashboardPage( WebDriver driver) {
		this.driver = driver;
		loginHelper = new LoginHelper(driver);
		StepLogger.setCaseId(1003, driver);
		StepLogger.stepId(1);
		StepLogger.preCondition("Navigate to My Money App.");
		User user = loginHelper.openMyMoneyApp(driver);
		StepLogger.stepId(2);
		StepLogger.preCondition("Login to My Money App.");
		loginHelper.loginToMyMoneyApp(user);
	}

	@TestTemplate
	@Feature("Dashboard Consolidated value check")
	public void verifyDashboardConsolidatedValueTest() throws InterruptedException {
		dashboardHelper = new DashboardHelper(driver);
		dashboardHelper.verifyTotalCreditsLabelText();
		dashboardHelper.verifyTotalDebitsLabelText();
		dashboardHelper.verifyConsolidatedLabelText();
		dashboardHelper.verifyConsolidatedValue();
	}

}
