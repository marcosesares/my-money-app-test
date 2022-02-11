package br.edu.mcesar.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import br.edu.mcesar.core.logger.StepLogger;
import io.github.bonigarcia.seljup.BrowserBuilder;
import io.github.bonigarcia.seljup.BrowsersTemplate.Browser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

public class BaseTest {

	@RegisterExtension
	protected static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

	@BeforeAll
	static void setup() {
		Browser chrome = BrowserBuilder.chrome().build();
		Browser firefox = BrowserBuilder.firefox().build();
		seleniumJupiter.addBrowsers(chrome);
		seleniumJupiter.addBrowsers(firefox);
	}

	@AfterEach
    public void tearDown() {
        StepLogger.takeScreenShot("Test finished running...");
    }
}
