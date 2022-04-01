package br.edu.mcesar.tests.e2e;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.Constants;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.Credits;
import br.edu.mcesar.pages.models.Debits;
import br.edu.mcesar.pages.models.Debits.Status;
import br.edu.mcesar.pages.models.PaymentCycle;
import br.edu.mcesar.pages.models.User;
import br.edu.mcesar.pages.paymentcycles.PaymentCyclesHelper;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Feature;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("e2e")
@ExtendWith(SeleniumJupiter.class)
public class PaymentCycleTests {

	private LoginHelper loginHelper;
	private PaymentCyclesHelper pageHelper;
	
	@BeforeEach
	void navigateToDashboardPage(WebDriver driver) {
		loginHelper = new LoginHelper(driver);
		pageHelper = new PaymentCyclesHelper(driver);
		
		StepLogger.setCaseId(1004, driver);
		StepLogger.stepId(1);
		StepLogger.preCondition("Navigate to My Money App.");
		User user = loginHelper.openMyMoneyApp(driver);
		StepLogger.stepId(2);
		StepLogger.preCondition("Login to My Money App.");
		loginHelper.loginToMyMoneyApp(user);
	}
	
	@Feature("Add a Payment Cycle")
	@ParameterizedTest
	@ArgumentsSource(value = PaymentCycleProvider.class)
	public void addPaymentCycleTest(PaymentCycle paymentCycle) {
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

	public static class PaymentCycleProvider implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
			Faker faker = new Faker();
			Credits credits = new Credits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX));
			Debits debits = new Debits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX), Status.AGENDADO);

			PaymentCycle paymentCycle = new PaymentCycle(faker.artist().name(), new Integer(faker.regexify(Constants.MONTH_REGEX)),
					new Integer(faker.regexify(Constants.YEAR_REGEX)), Arrays.asList(credits), Arrays.asList(debits));
			return Stream.of(paymentCycle).map(Arguments::of);
		}
		
	}
}
