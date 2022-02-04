package br.edu.mcesar.tests.smoke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;
import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Feature;

@Tag("smoke")
@Tag("integration")
@Tag("regression")
public class LoginTest {

	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;

	@RegisterExtension
	static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

	@BeforeAll
	static void setup() {
		Browser chrome = BrowserBuilder.chrome().build();
		Browser firefox = BrowserBuilder.firefox().build();
		Browser edge = BrowserBuilder.edge().build();
		Browser opera = BrowserBuilder.opera().build();
		seleniumJupiter.addBrowsers(chrome);
		seleniumJupiter.addBrowsers(firefox);
		seleniumJupiter.addBrowsers(edge);
		seleniumJupiter.addBrowsers(opera);
	}

	@TestTemplate
	@Feature("Login")
	public void loginTest(@Arguments("--headless") WebDriver driver) throws InterruptedException {
		User user = new User("Marcos Cesar", "marcosesares@gmail.com", "a2@MyMoney211");
		dashboardHelper = new DashboardHelper(driver);
		loginHelper = new LoginHelper(driver);
		StepLogger.setCaseId(1001, driver);

		StepLogger.stepId(1);
		StepLogger.step("Navigate to My Money App.");
		loginHelper.openMyMoneyApp(driver);
		StepLogger.verification("Verify My Money App logo is displayed.");
		loginHelper.verifyAppLogoDisplayedStatus();

		StepLogger.stepId(2);
		StepLogger.step("Login to My Money App.");
		loginHelper.fillLoginFormAndClickLoginButton(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}

}
