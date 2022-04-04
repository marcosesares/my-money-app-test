package br.edu.mcesar.core.api;

import static br.edu.mcesar.core.Constants.APPLICATION_PROPERTIES;

import java.util.Properties;

import br.edu.mcesar.core.ExpectationHelper;
import br.edu.mcesar.core.PropertiesUtil;

public class BaseRestApiHelper {
	
	protected static Properties properties = PropertiesUtil.getInstance().getProperties(APPLICATION_PROPERTIES);

	public static void verifyValue(String expectedText, String actualText, String elementName) {
		ExpectationHelper.verifyValue(expectedText, actualText, elementName);
	}
	
	public static void verifyNotEmpy(String expectedText, String elementName) {
		ExpectationHelper.verifyNotEmpty(expectedText, elementName);
	}
}
