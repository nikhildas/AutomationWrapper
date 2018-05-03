package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class ComverseTab {
	TestActions action = null;
	
	String currentBalance;
	int currentBalanceInt;
	String newBalance;
	
	By adjustBalance_ActionButton = By.xpath("//span[text()='Adjust Balance']");
	By balance_Cell = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']/descendant::td[2]");

	public ComverseTab(TestActions action) {
		this.action = action;
	}
	
	public void verifyComverseEnquiry() {
		By accountID = By.xpath("//*[contains(text(),'Account id')]/following::span[1]");
		By subscriberID = By.xpath("//*[contains(text(),'Subscriber id')]/following::span[1]");
		By currentState = By.xpath("//*[contains(text(),'Current State')]/following::span[1]");
		By previousState = By.xpath("//*[contains(text(),'Previous State')]/following::span[1]");
		
		action.waitFor(accountID, 10, true);
		
		TestActions.log("Account ID : "+action.getTextFromPage(accountID));
		TestActions.log("Subscriber ID : "+action.getTextFromPage(subscriberID));
		TestActions.log("Current State : "+action.getTextFromPage(currentState));
		TestActions.log("Previous State : "+action.getTextFromPage(previousState));
	}

	public boolean getHistoricalData() {
		By audits_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Audits']");
		By balanceAudit_Tab = By.xpath("//td[text()='Balance Audit']");
		
		boolean passed = false;
		
		passed = action.waitFor(audits_Tab, 5, true);
		passed = action.clickOn(audits_Tab);
		
		passed = action.waitFor(balanceAudit_Tab, 5, true);
		passed = action.waitFor(CommonPanel.Search_Button, 10, true);
		passed = action.clickOn(CommonPanel.Search_Button);
		action.waitFor(4);
		
		return passed;
	}
	
	public boolean changeBalance() {
		By balances_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Balances']");
		
		By balance_Row = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']");
				
		boolean passed = false;
		
		passed = action.waitFor(balances_Tab, 5, true);
		passed = action.clickOn(balances_Tab);
				
		passed = action.waitFor(balance_Row, 10, true);
		passed = action.clickOn(balance_Row);
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		
		currentBalance = action.getTextFromPage(balance_Cell);
		TestActions.log("Balance : " + currentBalance);

		currentBalance = currentBalance.split("\\.")[0];		
		TestActions.log("Balance for processing :" + currentBalance);
		
		currentBalanceInt = Integer.parseInt(currentBalance);
		TestActions.log("Balance in Integer :" + currentBalanceInt);

		return passed;
	}
	
	public boolean setBalance() {
		By setBalance_RadioButton = By.xpath("//label[text()='Set Balance?']");
		By amountSet_TextBox = By.xpath("//label[text()='New Balance:']/following::input[contains(@name, 'newBalanceAmount')]");
		By confirm_Button = By.xpath("//input[@value='Confirm']");

		boolean passed = false;
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		passed = action.clickOn(adjustBalance_ActionButton);
		
		passed = action.waitFor(setBalance_RadioButton, 10, true);
		passed = action.clickOn(setBalance_RadioButton);
		
		passed = action.waitFor(amountSet_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(amountSet_TextBox, Integer.toString(currentBalanceInt + 1));
		action.waitFor(2);
		
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 10, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		passed = action.waitFor(confirm_Button, 10, true);
		passed = action.clickOn(confirm_Button);

		passed = action.waitFor(confirm_Button, 10, false);
		action.waitFor(2);
		passed = CommonPanel.popUp.clickOK(action);
		action.waitFor(2);

		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		
		passed = currentBalance.equals(Integer.toString(currentBalanceInt+1));
		
		return passed;
	}
	
	public boolean adjustBalance() {
		By adjustBalance_RadioButton = By.xpath("//label[text()='Adjust Balance?']");
		By amountAdjusted_TextBox = By.xpath("//label[text()='Amount Adjusted:']/following::input[contains(@name, 'adjustmentAmount')]");
		
		By confirm_Button = By.xpath("//input[@value='Confirm']");
		
		boolean passed = false;
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		passed = action.clickOn(adjustBalance_ActionButton);
		
		passed = action.waitFor(adjustBalance_RadioButton, 10, true);
		passed = action.clickOn(adjustBalance_RadioButton);
		
		passed = action.waitFor(amountAdjusted_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(amountAdjusted_TextBox, "1.00");
		action.waitFor(2);
		
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 10, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		passed = action.waitFor(confirm_Button, 10, true);
		passed = action.clickOn(confirm_Button);

		passed = action.waitFor(confirm_Button, 10, false);
		action.waitFor(2);
		passed = CommonPanel.popUp.clickOK(action);
		action.waitFor(2);
		
		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		
		passed = currentBalance.equals(Integer.toString(currentBalanceInt+1));

		return passed;
	}
}
