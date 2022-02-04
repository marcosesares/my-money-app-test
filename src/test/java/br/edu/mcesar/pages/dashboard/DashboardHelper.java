package br.edu.mcesar.pages.dashboard;

import org.openqa.selenium.WebDriver;

import br.edu.mcesar.core.BaseHelper;

public class DashboardHelper extends BaseHelper {

	private DashboardPO po;

	public DashboardHelper(WebDriver driver) {
		super(driver);
		po = new DashboardPO(driver);
	}

	public void verifyDashboardSectionDisplayedStatus() {
		verifyDisplayedStatus(po.dashboardSection);
	}

	public void verifyUserNameLabelDisplayedStatus() {
		verifyDisplayedStatus(po.userNameLabel);
	}
}
