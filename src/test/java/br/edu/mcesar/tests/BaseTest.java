package br.edu.mcesar.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import br.edu.mcesar.core.logger.StepLogger;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class BaseTest {

	@RegisterExtension
	protected static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        seleniumJupiter.getConfig().setBrowserTemplateJsonFile(
                "./src/test/resources/browsers.json");
    }

	@AfterEach
    public void tearDown() {
        StepLogger.takeScreenShot("Test finished running...");
    }
}
