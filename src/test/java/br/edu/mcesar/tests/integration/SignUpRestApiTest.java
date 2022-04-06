package br.edu.mcesar.tests.integration;

import static br.edu.mcesar.core.Constants.CONTENT_TYPE;
import static br.edu.mcesar.core.Constants.EACH_STEP_SCREENSHOT;
import static br.edu.mcesar.core.Constants.EMAIL;
import static br.edu.mcesar.core.Constants.JSON_CHARSET;
import static br.edu.mcesar.core.Constants.NAME;
import static br.edu.mcesar.core.Constants.TOKEN;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import br.edu.mcesar.core.api.BaseRestApiHelper;
import br.edu.mcesar.core.api.SignUpRestApiHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.core.providers.UserProvider;
import br.edu.mcesar.pages.models.User;
import io.qameta.allure.Feature;
import io.restassured.http.Header;
import io.restassured.response.Response;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("component")
@ExtendWith(SystemStubsExtension.class)
public class SignUpRestApiTest {

	@SystemStub
	private EnvironmentVariables environmentVariables;

	@Feature("Sign Up Rest API")
	@ParameterizedTest
	@ArgumentsSource(value = UserProvider.class)
	void signUpTest(User user) throws Exception {

		environmentVariables.set(EACH_STEP_SCREENSHOT, "false");
		StepLogger.setCaseId(1005, null);
		StepLogger.stepId(1);
		StepLogger.step("Sign up to MyMoney app.");
		Response response = SignUpRestApiHelper.postUserSignUp(user);

		StepLogger.verification("Verify the Response Content-Type.");
		Header contentType = response.headers().get(CONTENT_TYPE);
		BaseRestApiHelper.verifyValue(JSON_CHARSET, contentType.getValue(), CONTENT_TYPE);

		StepLogger.verification("Verify the Response body user name.");
		String userName = response.jsonPath().get(NAME);
		BaseRestApiHelper.verifyValue(user.getName(), userName, NAME);

		StepLogger.verification("Verify the Response body user name.");
		String userEmail = response.jsonPath().get(EMAIL);
		BaseRestApiHelper.verifyValue(user.getEmail(), userEmail, EMAIL);

		StepLogger.verification("Verify the Response body user name.");
		String token = response.jsonPath().get(TOKEN);
		BaseRestApiHelper.verifyNotEmpy(token, TOKEN);
	}
}
