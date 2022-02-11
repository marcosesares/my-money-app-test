package br.edu.mcesar.pages.paymentcycles;

public class PaymentCyclesPOConstants {

	public static final String BUTTON_CANCEL = "//button[normalize-space()='Cancel']";
	public static final String BUTTON_SAVE = "//button[normalize-space()='Save']";
	public static final String TEXTBOX_BILLING_YEAR = "input[placeholder='Inform the billing Year']";
	public static final String TEXTBOX_MONTH = "input[placeholder='Inform the billing Month']";
	public static final String TEXTBOX_NAME = "input[placeholder='Inform the billing Name']";
	public static final String COLUMN_ACTIONS = "//div[@id='tabList']//th[contains(text(),'Actions')]";
	public static final String COLUMN_YEAR = "//div[@id='tabList']//th[contains(text(),'Year')]";
	public static final String COLUMN_MONTH = "//div[@id='tabList']//th[contains(text(),'Month')]";
	public static final String COLUMN_NAME = "//div[@id='tabList']//th[contains(text(),'Name')]";
	public static final String BUTTON_TAB_CREATE = "button[data-target='tabCreate']";
	public static final String BUTTON_TAB_LIST = "button[data-target='tabList']";
	public static final String NAME = "Name Textbox";
	public static final String MONTH = "Month Textbox";
	public static final String YEAR = "Year Textbox";
}
