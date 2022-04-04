package br.edu.mcesar.core;

public class Constants {

    public static final String MONTH_REGEX = "0?[1-9]|1[012]";
    public static final String YEAR_REGEX = "(19[7-9][0-9])|(20[0-4][0-9])";
    public static final String NUMBER_REGEX = "[0-9]{4}";
    public static final String EMAIL_REGEX = "[a-zA-Z]{8}[0-9]{4}\\@[a-zA-Z]{5}\\.[a-zA-Z]{3}";
    public static final String PASSWORD_REGEX = "[a-z][0-9][@#$%][a-zA-Z]{6}[0-9]{3}";
    public static final String DECIMAL_FORMAT = "0.#";
    public static final String EMPTY_STRING = "";
    public static final String DOLLAR_REGEX = "\\$";
    public static final String DOLLAR = "$";
    public static final String PAYMENT_CYCLE_HEADER = "Payment Cycle Register";
    public static final String PAGE_HEADER_SECTION = "Page Header section";
    public static final String USER_PROPERTIES = "user.properties";
    public static final String APPLICATION_PROPERTIES = "application.properties";
    public static final String SIGNUP_PATH = "/signup";
    public static final String URLENC_CHARSET = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final String JSON_CHARSET = "application/json; charset=utf-8";
    public static final String FORM_URLENC = "x-www-form-urlencoded";
    public static final String OPEN_ENDPOINT = "openEndpoint";
    public static final String BASE_URL = "baseUrl";
    public static final String ENDPOINT = "endpoint";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String TOKEN = "token";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirm_password";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String EACH_STEP_SCREENSHOT = "EACH_STEP_SCREENSHOT";

	private Constants() {}
}
