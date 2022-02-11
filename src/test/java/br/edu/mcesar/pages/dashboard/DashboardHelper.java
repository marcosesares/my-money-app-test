package br.edu.mcesar.pages.dashboard;

import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.CONSOLIDATED;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.TOTAL_CREDITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.TOTAL_DEBITS;
import static br.edu.mcesar.pages.dashboard.DashboardPOConstants.USERNAME;

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
		verifyDisplayedStatus(po.getHeaderSectionLabel(), Constants.PAGE_HEADER_SECTION);
	}

	public void verifyUserNameLabelDisplayedStatus() {
		verifyDisplayedStatus(po.getUserNameLabel(), USERNAME);
	}
	
	public void verifyTotalCreditsLabelText() {
		verifyDisplayedStatus(po.getTotalCreditsLabel(), TOTAL_CREDITS);
		verifyElementTextEqualTo(po.getTotalCreditsLabel(), TOTAL_CREDITS, null);
	}
	
	public void verifyTotalDebitsLabelText() {
		verifyDisplayedStatus(po.getTotalDebitsLabel(), TOTAL_DEBITS);
		verifyElementTextEqualTo(po.getTotalDebitsLabel(), TOTAL_DEBITS, null);
	}
	
	public void verifyConsolidatedLabelText() {
		verifyDisplayedStatus(po.getConsolidatedLabel(), CONSOLIDATED);
		verifyElementTextEqualTo(po.getConsolidatedLabel(), CONSOLIDATED, null);
	}
	
	public void verifyConsolidatedValue() {
		DecimalFormat format = new DecimalFormat(Constants.DECIMAL_FORMAT);
		Double credits = Double.valueOf(po.getTotalCreditsValue().getText().replaceAll(Constants.DOLLAR_REGEX, Constants.EMPTY_STRING));
		Double debits = Double.valueOf(po.getTotalDebitsValue().getText().replaceAll(Constants.DOLLAR_REGEX, Constants.EMPTY_STRING));
		Double total = credits - debits;
		verifyElementTextEqualTo(po.getConsolidatedValue(), Constants.DOLLAR + format.format(total), CONSOLIDATED);
	}
}
