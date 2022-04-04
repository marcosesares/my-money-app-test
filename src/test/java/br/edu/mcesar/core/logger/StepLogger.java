package br.edu.mcesar.core.logger;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static br.edu.mcesar.core.Constants.EACH_STEP_SCREENSHOT;

public class StepLogger {

	public static Logger logger;
	static Integer id;
	static Integer testCaseId;
	static Long testStart;
	static String stepIdVar = "";
	static String logMessages = "";
	static Boolean eachStepScreenshot = System.getenv(EACH_STEP_SCREENSHOT) != null
			? Boolean.valueOf(System.getenv(EACH_STEP_SCREENSHOT))
			: true;
	private static WebDriver driver;

	private StepLogger() {
	}

	public static void setCaseId(Integer theCaseId, WebDriver webDriver) {
		driver = webDriver;
		testCaseId = theCaseId;
		logger = LogManager.getLogger("C" + theCaseId);
		id = 1;
		logMessages = "";
		testStart = new Date().getTime();
	}

	@Step("Step: {stepName}")
	public static void step(String stepName) {
		String operation = "Pre-Condition";
		if (testCaseId != null) {
			operation = "Step";
		}
		commonLogger(operation, stepName);
	}

	@Step("Step: {stepId}")
	public static void stepId(Integer stepId) {
		id = stepId != null ? stepId : id + 1;
		commonLogger("Step Id", id.toString());
	}

	@Step("Verification: {verificationDescription}")
	public static void verification(String verificationDescription) {
		commonLogger("Verification", verificationDescription);
	}

	@Step("Pre-Condition: {preConditionDescription}")
	public static void preCondition(String preConditionDescription) {
		commonLogger("Pre-Condition", preConditionDescription);
	}

	@Step("{postConditionDescription}")
	public static void postCondition(String postConditionDescription) {
		commonLogger("Post-Condition", postConditionDescription);
	}

	@Step("Sub-step: {stepName}")
	public static void subStep(String stepName) {
		commonLogger("Sub-Step", stepName);
		if (eachStepScreenshot) {
			takeScreenShot("Sub-step" + stepName);
		}
	}

	@Step("Sub-Verification: {verificationDescription}")
	public static void subVerification(String verificationDescription) {
		commonLogger("Sub-Verification", verificationDescription);
		if (eachStepScreenshot) {
			takeScreenShot("Sub-Verification" + verificationDescription);
		}
	}

	@Step("Sub-step: {stepName}")
	public static void subStep(String stepName, WebElement element) {
		commonLogger("Sub-Step", stepName);
		if (eachStepScreenshot) {
			takeScreenShot("Sub-step" + stepName, element);
		}
	}

	@Step("Sub-Verification: {verificationDescription}")
	public static void subVerification(String verificationDescription, WebElement element) {
		commonLogger("Sub-Verification", verificationDescription);
		if (eachStepScreenshot) {
			takeScreenShot("Sub-Verification" + verificationDescription, element);
		}
	}

	@Attachment(value = "{0}", type = "image/png")
	public static byte[] takeScreenShot(String attachmentName, WebElement element) {
		elementHighlight(element, 5);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		elementHighlight(element, 0);
		return screenshot;
	}

	@Attachment(value = "{0}", type = "image/png")
	public static byte[] takeScreenShot(String attachmentName) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public static void elementHighlight(WebElement element, Integer borderWidth) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String h = "arguments[0].style.cssText = 'border-width: " + borderWidth + "px; border-style: solid; border-color: red'";
			js.executeScript(h, new Object[] { element });
		}
	}

	public static void commonLogger(String operation, String step) {
		String message = stepIdVar + "- *" + operation + "* - " + step;
		if (testStart != null) {
			Long passed = new Date().getTime() - testStart;
			message = " +" + passed / 1000 + "s " + message;
		}
		if (logger != null) {
			logger.debug(message);
		} else {
			logMessages += message + "\n";
		}
	}
}
