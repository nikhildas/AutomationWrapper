package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOWaitlist {
	private TestActions action = null;

	public String ServiceOrderNumber = "";

	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");
	By accpet_Button = By.xpath("//input[@value='Accept']");
	By waitlistReason_DropDown = By.xpath("//*[text()='Waitlist Details']/following::select[1]");
	By firstProduct_Row = By.xpath("//tr[@id='waitlistServiceOrderForm:waitListSolinesList_row_0']");
	
	public MSOWaitlist(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.Waitlist, 4, true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Waitlist);

		return passed;
	}

	public boolean searchSearviceOrder(String department, String ServiceOrderNumber) {
		boolean passed = false;
		if (!department.trim().equals("") && !ServiceOrderNumber.trim().equals("")) {
			this.ServiceOrderNumber = ServiceOrderNumber;
			passed = CommonPanel.SearchServiceOrder(action, department, ServiceOrderNumber);
		}

		else {
			passed = action.clickOn(CommonPanel.ServiceOrderList.serviceOrderList_Header);
			passed = action.waitFor(CommonPanel.ServiceOrderList.ServiceOrderList_Row("[1]"), 4, true);
			this.ServiceOrderNumber = action
					.getTextFromPage(CommonPanel.ServiceOrderList.ServiceOrderList_Row("[1]/descendant::td[1]"));
			passed = action.clickOn(CommonPanel.ServiceOrderList.ServiceOrderList_Row("[1]"));
		}
		return passed;
	}

	public boolean verifyServiceOrdeDetails(String ServiceOrderNumber) {
		boolean passed = false;

		passed = action.waitFor(serviceOrder_Value, 3, true);
		passed = action.getTextFromPage(serviceOrder_Value).trim().equals(ServiceOrderNumber) ? true : false;

		return passed;
	}

	public boolean waitlistServiceOrder() {
		boolean passed = false;
		
		passed = action.waitFor(waitlistReason_DropDown, 3, true);
		passed = action.selectByPartialText(waitlistReason_DropDown, "Approval");
		
		passed = action.waitFor(firstProduct_Row, 3, true);
		passed = action.clickOn(firstProduct_Row);
		
		passed = action.waitFor(accpet_Button, 3, true);
		passed = action.clickOn(accpet_Button);
		
		action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		return passed;
	}
}
