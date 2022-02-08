package br.edu.mcesar.pages.dashboard;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.Constants;

public class DashboardHelper extends BaseHelper {

	private DashboardPO po;

	public DashboardHelper(WebDriver driver) {
		super(driver);
		po = new DashboardPO(driver);
	}

	public void verifyDashboardSectionDisplayedStatus() {
		verifyDisplayedStatus(po.getHeaderSectionLabel());
	}

	public void verifyUserNameLabelDisplayedStatus() {
		verifyDisplayedStatus(po.getUserNameLabel());
	}
	
	public void verifyTotalCreditsLabelText() {
		verifyDisplayedStatus(po.getTotalCreditsLabel());
		verifyElementTextEqualTo(po.getTotalCreditsLabel(), Constants.TOTAL_CREDITS, null);
	}
	
	public void verifyTotalDebitsLabelText() {
		verifyDisplayedStatus(po.getTotalDebitsLabel());
		verifyElementTextEqualTo(po.getTotalDebitsLabel(), Constants.TOTAL_DEBITS, null);
	}
	
	public void verifyConsolidatedLabelText() {
		verifyDisplayedStatus(po.getConsolidatedLabel());
		verifyElementTextEqualTo(po.getConsolidatedLabel(), Constants.CONSOLIDATED, null);
	}
	
	public void verifyConsolidatedValue() {
		DecimalFormat format = new DecimalFormat(Constants.DECIMAL_FORMAT);
		Double credits = Double.valueOf(po.getTotalCreditsValue().getText().replaceAll(Constants.DOLLAR_REGEX, Constants.EMPTY_STRING));
		Double debits = Double.valueOf(po.getTotalDebitsValue().getText().replaceAll(Constants.DOLLAR_REGEX, Constants.EMPTY_STRING));
		Double total = credits - debits;
		verifyElementTextEqualTo(po.getConsolidatedValue(), Constants.DOLLAR + format.format(total), Constants.CONSOLIDATED);
	}
}
