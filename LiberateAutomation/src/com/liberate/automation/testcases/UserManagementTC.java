package com.liberate.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.MaintainEmployee;
import com.liberate.automation.pom.ManageUser;

/***
 * Class with all User Management Test Cases
 * @author Nikhil
 *
 */
public class UserManagementTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
		
	static String TestCase;
	static String TestStatus;
	
	static String employeeUserName = "";
	static String newUserID = "";
	
	/**
	 * Private constructor to disable creation of object
	 */
	private UserManagementTC() {
	}
	
	@BeforeClass
	public static void loadData() {
		employeeUserName = TestData.employeeUserName;
		newUserID = TestData.newUserID;
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(testCase);
		testStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		action.log("Test Status : " + testStatus);
		action.log("*****COMPLETED '" + testCase + "' EXECUTION***** \n");
	}
	
	@Test(priority = 1)
	public static void amendUser() {
		TestCase = "UserManagementTC_amendUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(TestCase);
		adm.amendUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 2)
	public static void copyUser() {
		TestCase = "UserManagementTC_copyUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(TestCase);
		adm.copyUser("99999");
		action.getScreenShot(TestCase);
		adm.verifyCopyUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 3)
	public static void createUser() {
		TestCase = "UserManagementTC_createUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageUser adm = new ManageUser(action);
		MaintainEmployee ade = new MaintainEmployee(action);

		ade.navigate();
		ade.searchWithStaffNumber(newUserID);
		ade.createNewEmployee();

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("");
		action.getScreenShot(TestCase);
		adm.createUser(ade.EmployeeID, ade.VMSUserName);
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 4)
	public static void deleteUser() {
		TestCase = "UserManagementTC_deleteUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserIS(newUserID);
		action.getScreenShot(TestCase);
		adm.deleteUser();
		action.getScreenShot(TestCase);
		adm.verifyDelete();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

}
