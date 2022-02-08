package br.edu.mcesar.pages.paymentcycles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class PaymentCyclesPO extends BasePO {

	@FindBy(css = "button[data-target='tabList']")
	private WebElement listTabButton;

	@FindBy(css = "button[data-target='tabCreate']")
	private WebElement addTabButton;

	@FindBy(xpath = "//div[@id='tabList']//th[contains(text(),'Name')]")
	private WebElement nameColumn;

	@FindBy(xpath = "//div[@id='tabList']//th[contains(text(),'Month')]")
	private WebElement monthColumn;

	@FindBy(xpath = "//div[@id='tabList']//th[contains(text(),'Year')]")
	private WebElement yearColumn;

	@FindBy(xpath = "//div[@id='tabList']//th[contains(text(),'Actions')]")
	private WebElement actionsColumn;

	@FindBy(css = "input[placeholder='Inform the billing Name']")
	private WebElement nameTextbox;
	
	@FindBy(css = "input[placeholder='Inform the billing Month']")
	private WebElement monthTextbox;
	
	@FindBy(css = "input[placeholder='Inform the billing Year']")
	private WebElement yearTextbox;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelButton;
	
	protected PaymentCyclesPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getListTableCell(String column, String value) {
		return driver.findElement(By.xpath(
				"//div[@id='tabList']"
						+ "//td[count(//table/thead/tr"
						+ "/th[.='" + column + "']/preceding-sibling::th)+1][normalize-space()='" + value + "']"));
	}

	public WebElement getCreditAddButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Credits']]]"
			  + "//input[@name='credits[" + row + "].name']"
	  		  + "/parent::td/parent::tr"
	  		  + "//button[contains(@class, 'btn-success')]"));
	}

	public WebElement getCreditCopyButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Credits']]]"
						+ "//input[@name='credits[" + row + "].name']"
						+ "/parent::td/parent::tr"
						+ "//button[contains(@class, 'btn-warning')]"));
	}

	public WebElement getCreditDeleteButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Credits']]]"
						+ "//input[@name='credits[" + row + "].name']"
						+ "/parent::td/parent::tr"
						+ "//button[contains(@class, 'btn-danger')]"));
	}
	
	public WebElement getCreditValueTextbox(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Credits']]]"
						+ "//input[@name='credits[" + row + "].value']"));
	}
	
	public WebElement getCreditNameTextbox(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Credits']]]"
						+ "//input[@name='credits[" + row + "].name']"));
	}

	public WebElement getDebitAddButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].name']"
						+ "/parent::td/parent::tr"
						+ "//button[contains(@class, 'btn-success')]"));
	}
	
	public WebElement getDebitCopyButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].name']"
						+ "/parent::td/parent::tr"
						+ "//button[contains(@class, 'btn-warning')]"));
	}
	
	public WebElement getDebitDeleteButton(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].name']"
						+ "/parent::td/parent::tr"
						+ "//button[contains(@class, 'btn-danger')]"));
	}
	
	public WebElement getDebitValueTextbox(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].value']"));
	}
	
	public WebElement getDebitNameTextbox(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].name']"));
	}

	public WebElement getDebitStatusTextbox(Integer row) {
		return driver.findElement(By.xpath(
				"//div[fieldset[legend[normalize-space()='Debits']]]"
						+ "//input[@name='debts[" + row + "].status']"));
	}
	
	public WebElement getListTabButton() {
		return listTabButton;
	}

	public WebElement getAddTabButton() {
		return addTabButton;
	}

	public WebElement getNameColumn() {
		return nameColumn;
	}

	public WebElement getMonthColumn() {
		return monthColumn;
	}

	public WebElement getYearColumn() {
		return yearColumn;
	}

	public WebElement getActionsColumn() {
		return actionsColumn;
	}

	public WebElement getNameTextbox() {
		return nameTextbox;
	}

	public WebElement getMonthTextbox() {
		return monthTextbox;
	}

	public WebElement getYearTextbox() {
		return yearTextbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
}
