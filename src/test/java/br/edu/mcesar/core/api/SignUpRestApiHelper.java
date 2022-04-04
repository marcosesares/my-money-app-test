package br.edu.mcesar.core.api;
import static br.edu.mcesar.core.Constants.CONFIRM_PASSWORD;
import static br.edu.mcesar.core.Constants.EMAIL;
import static br.edu.mcesar.core.Constants.FORM_URLENC;
import static br.edu.mcesar.core.Constants.NAME;
import static br.edu.mcesar.core.Constants.OPEN_ENDPOINT;
import static br.edu.mcesar.core.Constants.PASSWORD;
import static br.edu.mcesar.core.Constants.SIGNUP_PATH;
import static br.edu.mcesar.core.Constants.URLENC_CHARSET;

import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.models.User;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SignUpRestApiHelper extends BaseRestApiHelper {

	public static Response postUserSignUp(User user) {
		RestAssured.baseURI = properties.getProperty(OPEN_ENDPOINT);
		StepLogger.subStep("Sign up to MyMoney app.");
		Response response = RestAssured.given()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs(FORM_URLENC, ContentType.URLENC)))
				.contentType(URLENC_CHARSET).formParam(EMAIL, user.getEmail()).formParam(PASSWORD, user.getPassword())
				.formParam(CONFIRM_PASSWORD, user.getPassword()).formParam(NAME, user.getName()).post(SIGNUP_PATH);
		return response;
	}
}
