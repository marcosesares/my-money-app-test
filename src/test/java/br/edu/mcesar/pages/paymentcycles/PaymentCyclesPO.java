package br.edu.mcesar.pages.paymentcycles;

import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.BUTTON_CANCEL;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.BUTTON_SAVE;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.BUTTON_TAB_CREATE;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.BUTTON_TAB_LIST;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.COLUMN_ACTIONS;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.COLUMN_MONTH;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.COLUMN_NAME;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.COLUMN_YEAR;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.TEXTBOX_BILLING_YEAR;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.TEXTBOX_MONTH;
import static br.edu.mcesar.pages.paymentcycles.PaymentCyclesPOConstants.TEXTBOX_NAME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class PaymentCyclesPO extends BasePO {

	@FindBy(css = BUTTON_TAB_LIST)
	private WebElement listTabButton;

	@FindBy(css = BUTTON_TAB_CREATE)
	private WebElement addTabButton;

	@FindBy(xpath = COLUMN_NAME)
	private WebElement nameColumn;

	@FindBy(xpath = COLUMN_MONTH)
	private WebElement monthColumn;

	@FindBy(xpath = COLUMN_YEAR)
	private WebElement yearColumn;

	@FindBy(xpath = COLUMN_ACTIONS)
	private WebElement actionsColumn;

	@FindBy(css = TEXTBOX_NAME)
	private WebElement nameTextbox;
	
	@FindBy(css = TEXTBOX_MONTH)
	private WebElement monthTextbox;
	
	@FindBy(css = TEXTBOX_BILLING_YEAR)
	private WebElement yearTextbox;
	
	@FindBy(xpath = BUTTON_SAVE)
	private WebElement saveButton;
	
	@FindBy(xpath = BUTTON_CANCEL)
	private WebElement cancelButton;
	
	protected PaymentCyclesPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getListTableCell(String column, String value) {
		String xpathExpression = 
				  "//div[@id='tabList']"
				+ "//td[count(//table/thead/tr"
				+ "/th[.='" + column + "']/preceding-sibling::th)+1][normalize-space()='" + value + "']";
		return findElementByxPath(xpathExpression);
	}

	public WebElement getCreditAddButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Credits']]]"
				+ "//input[@name='credits[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-success')]";
		return findElementByxPath(xpathExpression);
	}

	public WebElement getCreditCopyButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Credits']]]"
				+ "//input[@name='credits[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-warning')]";
		return findElementByxPath(xpathExpression);
	}

	public WebElement getCreditDeleteButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Credits']]]"
				+ "//input[@name='credits[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-danger')]";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getCreditValueTextbox(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Credits']]]"
				+ "//input[@name='credits[" + row + "].value']";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getCreditNameTextbox(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Credits']]]"
				+ "//input[@name='credits[" + row + "].name']";
		return findElementByxPath(xpathExpression);
	}

	public WebElement getDebitAddButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-success')]";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getDebitCopyButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-warning')]";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getDebitDeleteButton(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].name']"
				+ "/parent::td/parent::tr"
				+ "//button[contains(@class, 'btn-danger')]";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getDebitValueTextbox(Integer row) {
		String xpathExpression = 
				  "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].value']";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getDebitNameTextbox(Integer row) {
		String xpathExpression = "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].name']";
		return findElementByxPath(xpathExpression);
	}

	public WebElement getDebitStatusTextbox(Integer row) {
		String xpathExpression = "//div[fieldset[legend[normalize-space()='Debits']]]"
				+ "//input[@name='debts[" + row + "].status']";
		return findElementByxPath(xpathExpression);
	}
	
	public WebElement getListTabButton() { return listTabButton; }

	public WebElement getAddTabButton() { return addTabButton; }

	public WebElement getNameColumn() { return nameColumn; }

	public WebElement getMonthColumn() { return monthColumn; }

	public WebElement getYearColumn() { return yearColumn; }

	public WebElement getActionsColumn() { return actionsColumn; }

	public WebElement getNameTextbox() { return nameTextbox; }

	public WebElement getMonthTextbox() { return monthTextbox; }

	public WebElement getYearTextbox() { return yearTextbox; }

	public WebElement getSaveButton() { return saveButton; }

	public WebElement getCancelButton() { return cancelButton; }
}
