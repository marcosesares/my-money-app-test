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

	private Constants() {}
}
