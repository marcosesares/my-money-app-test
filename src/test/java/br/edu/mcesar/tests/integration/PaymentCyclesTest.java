package br.edu.mcesar.tests.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.PaymentCycle;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.pages.paymentcycles.PaymentCyclesHelper;
import br.edu.mcesar.tests.BaseTest;
import io.github.bonigarcia.seljup.Arguments;
import io.qameta.allure.Feature;

@Tag("integration")
@Tag("regression")
public class PaymentCyclesTest extends BaseTest {

	private LoginHelper loginHelper;
	private PaymentCyclesHelper pageHelper;
	private WebDriver driver;
	
	@BeforeEach
	void navigateToDashboardPage(@Arguments("--headless") WebDriver driver) {
		this.driver = driver;
		loginHelper = new LoginHelper(driver);
		StepLogger.setCaseId(1004, driver);
		StepLogger.stepId(1);
		StepLogger.preCondition("Navigate to My Money App.");
		User user = loginHelper.openMyMoneyApp(driver);
		StepLogger.stepId(2);
		StepLogger.preCondition("Login to My Money App.");
		loginHelper.loginToMyMoneyApp(user);
	}

	@Test
	@Feature("Verify Open Payment Cycles page")
	public void verifyDashboardConsolidatedValueTest() throws InterruptedException {
		StepLogger.stepId(1);
		StepLogger.step("Navigate to Payment Cycles page.");
		pageHelper = new PaymentCyclesHelper(driver);
		pageHelper.navigateToPaymentCyclesPage();
		StepLogger.verification("Verify Payment Cycles page is displayed.");
		pageHelper.verifyPaymentCycleSectionLabel();
	}

	@TestTemplate
	@Feature("Add a Payment Cycle")
	public void addPaymentCycleTest() throws InterruptedException {
		pageHelper = new PaymentCyclesHelper(driver);
		PaymentCycle paymentCycle = pageHelper.getPaymentCycle();

		StepLogger.stepId(1);
		StepLogger.preCondition("Navigate to Payment Cycles page.");
		pageHelper.navigateToPaymentCyclesPage();
		
		StepLogger.stepId(2);
		StepLogger.step("Click the Add a Payment Cycle button.");
		pageHelper.clickAddButton();
		StepLogger.verification("Verify Add a Payment Cycle form is displayed.");
		pageHelper.verifyAddPaymentCycleFormDisplayed();
		
		StepLogger.stepId(3);
		StepLogger.step("Add a Payment Cycle.");
		pageHelper.fillPaymentCycleFormAndClickSaveButton(paymentCycle);
		StepLogger.verification("Verify the Payment Cycle is displayed.");
		pageHelper.verifyPaymentCycleDisplayed(paymentCycle);
		
	}

}
