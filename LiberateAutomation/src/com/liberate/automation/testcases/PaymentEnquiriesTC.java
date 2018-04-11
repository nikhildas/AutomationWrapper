package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYPaymentEnquiriesPOM;

/***
 * Class with Payment Enquiries Test Cases
 * 
 * @author Nikhil
 *
 */
public class PaymentEnquiriesTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
		
	/**
	 * Private constructor to disable creation of object
	 */
	private PaymentEnquiriesTC() {
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(testCase);
		testStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		action.log("Test Status : " + testStatus);
		action.log("*****COMPLETED '" + testCase + "' EXECUTION***** \n");
	}
	
	@Test
	public static void searchWithAccountNumber() {
		String TestCase = "PaymentEnquiries_searchWithAccountNumber";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		PYPaymentEnquiriesPOM pe = new PYPaymentEnquiriesPOM(action);

		action.getScreenShot(TestCase);
		assertEquals(pe.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(pe.paymentEnquiryWithAccountNumber("260002280000"), true);
		action.getScreenShot(TestCase);
		String acctnum = action
				.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table/tbody/tr[2]/td[2]"));
		action.getScreenShot(TestCase);
		System.out.println("Searched Account number is" + " " + acctnum);
		if (acctnum.equals("260002280000")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
