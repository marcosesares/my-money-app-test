package br.edu.mcesar.tests.integration;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.Constants;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.Credits;
import br.edu.mcesar.pages.models.Debits;
import br.edu.mcesar.pages.models.PaymentCycle;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.pages.models.Debits.Status;
import br.edu.mcesar.pages.paymentcycles.PaymentCyclesHelper;
import br.edu.mcesar.tests.BaseTest;
import io.qameta.allure.Feature;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("integration")
public class PaymentCyclesTest extends BaseTest {

	private LoginHelper loginHelper;
	private PaymentCyclesHelper pageHelper;
	private WebDriver driver;
	
	@BeforeEach
	void navigateToDashboardPage(WebDriver driver) {
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

	@TestTemplate
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
		StepLogger.step("Navigate to Payment Cycles page.");
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

	@DataProvider
	public Object[][] getPaymentCycle() {
		Faker faker = new Faker();
		Credits credits = new Credits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX));
		Debits debits = new Debits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX), Status.AGENDADO);

		PaymentCycle paymentCycle = new PaymentCycle(faker.artist().name(), new Integer(faker.regexify(Constants.MONTH_REGEX)),
				new Integer(faker.regexify(Constants.YEAR_REGEX)), Arrays.asList(credits), Arrays.asList(debits));
		return null;
	}
}
