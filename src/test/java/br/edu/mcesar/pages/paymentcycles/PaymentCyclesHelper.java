package br.edu.mcesar.pages.paymentcycles;

import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.MONTH;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.NAME;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.YEAR;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.Constants;
import br.edu.mcesar.core.WaitHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.models.Credits;
import br.edu.mcesar.pages.models.Debits;
import br.edu.mcesar.pages.models.Debits.Status;
import br.edu.mcesar.pages.models.PaymentCycle;

public class PaymentCyclesHelper extends BaseHelper {

	private PaymentCyclesPO po;
	private WaitHelper waitHelper;

	public PaymentCyclesHelper(WebDriver driver) {
		super(driver);
		po = new PaymentCyclesPO(driver);
		waitHelper = new WaitHelper(driver);
	}

	public void navigateToPaymentCyclesPage() {
		waitHelper.waitForElementToBeDisplayed(po.getRegisterMenuLink());
		StepLogger.subStep("Click the Register menu", po.getRegisterMenuLink());
		while (!po.getPaymentCyclesMenuLink().isDisplayed()) {
			po.getRegisterMenuLink().click();
			waitHelper.waitForElementToBeDisplayed(po.getPaymentCyclesMenuLink());
		}
		clickElement(po.getPaymentCyclesMenuLink());
	}

	private void clickElement(WebElement element) {
		StepLogger.subStep("Click the Payment Cycles menu", element);
		element.click();
	}

	public void verifyPaymentCycleSectionLabel() {
		verifyDisplayedStatus(po.getHeaderSectionLabel(), Constants.PAGE_HEADER_SECTION);
		verifyElementTextEqualTo(po.getHeaderSectionLabel(), Constants.PAYMENT_CYCLE_HEADER,
				Constants.PAGE_HEADER_SECTION);
	}

	public void clickAddButton() {
		StepLogger.subStep("Click on the Add button under Payment Cycle section.", po.getAddTabButton());
		po.getAddTabButton().click();
	}

	public void verifyPaymentCycleDisplayed(PaymentCycle paymentCycle) {
		verifyPaymentCycleSectionLabel();
		waitForElementToBeDisplayed(po.getListTableCell("Name", paymentCycle.getName()));
		WebElement nameCell = po.getListTableCell("Name", paymentCycle.getName());
		verifyElementTextEqualTo(nameCell, paymentCycle.getName(), "Payment Cycle name");

		WebElement monthCell = po.getListTableCell("Month", String.valueOf(paymentCycle.getMonth()));
		verifyElementTextEqualTo(monthCell, String.valueOf(paymentCycle.getMonth()), "Payment Cycle month");

		WebElement yearCell = po.getListTableCell("Year", String.valueOf(paymentCycle.getYear()));
		verifyElementTextEqualTo(yearCell, String.valueOf(paymentCycle.getYear()), "Payment Cycle year");
	}

	public void verifyAddPaymentCycleFormDisplayed() {
		verifyDisplayedStatus(po.getNameTextbox(), NAME);
		verifyDisplayedStatus(po.getMonthTextbox(), MONTH);
		verifyDisplayedStatus(po.getYearTextbox(), YEAR);
	}

	public PaymentCycle getPaymentCycle() {
		Faker faker = new Faker();
		Credits credits = new Credits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX));
		Debits debits = new Debits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX), Status.AGENDADO);

		PaymentCycle paymentCycle = new PaymentCycle(faker.artist().name(),
				Integer.parseInt(faker.regexify(Constants.MONTH_REGEX)),
				Integer.parseInt(faker.regexify(Constants.YEAR_REGEX)), Arrays.asList(credits), Arrays.asList(debits));
		return paymentCycle;
	}

	public void fillPaymentCycleFormAndClickSaveButton(PaymentCycle paymentCycle) {
		StepLogger.subStep("Type the payment cycle name.", po.getNameTextbox());
		sendKeys(po.getNameTextbox(), paymentCycle.getName());

		StepLogger.subStep("Type the payment cycle month.", po.getMonthTextbox());
		sendKeys(po.getMonthTextbox(), String.valueOf(paymentCycle.getMonth()));

		StepLogger.subStep("Type the payment cycle year.", po.getYearTextbox());
		sendKeys(po.getYearTextbox(), String.valueOf(paymentCycle.getYear()));

		addPaymentCredit(paymentCycle);
		addPaymentDebit(paymentCycle);

		StepLogger.subStep("Click the Save button.", po.getSaveButton());
		scrollToElement(po.getSaveButton());
		po.getSaveButton().click();
	}

	private void addPaymentCredit(PaymentCycle paymentCycle) {
		for (int i = 0; i < paymentCycle.getCredits().size(); i++) {
			Credits credit = paymentCycle.getCredits().get(i);
			StepLogger.subStep("Type the payment cycle credit name.", po.getCreditNameTextbox(i));
			sendKeys(po.getCreditNameTextbox(i), credit.getName());

			StepLogger.subStep("Type the payment cycle credit value.", po.getCreditValueTextbox(i));
			sendKeys(po.getCreditValueTextbox(i), credit.getValue());

			if (i + 1 < paymentCycle.getCredits().size()) {
				StepLogger.subStep("Click the payment cycle credit Add button.", po.getCreditAddButton(i));
				po.getCreditAddButton(i).click();
			}
		}
	}

	private void addPaymentDebit(PaymentCycle paymentCycle) {
		for (int i = 0; i < paymentCycle.getDebits().size(); i++) {
			Debits debit = paymentCycle.getDebits().get(i);
			StepLogger.subStep("Type the payment cycle debit name.", po.getDebitNameTextbox(i));
			sendKeys(po.getDebitNameTextbox(i), debit.getName());

			StepLogger.subStep("Type the payment cycle debit value.", po.getDebitValueTextbox(i));
			sendKeys(po.getDebitValueTextbox(i), debit.getValue());

			StepLogger.subStep("Type the payment cycle debit status.", po.getDebitStatusTextbox(i));
			sendKeys(po.getDebitStatusTextbox(i), debit.getStatus().name());

			if (i + 1 < paymentCycle.getDebits().size()) {
				StepLogger.subStep("Click the payment cycle debit Add button.", po.getDebitAddButton(i));
				po.getDebitAddButton(i).click();
			}
		}
	}
}
