package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.ManageFault;
import com.liberate.automation.pom.RaiseFault;

public class FaultManagement {
	static TestActions action = CommonLogin.action;

	@Test
	public static void raiseFault() {
		String TestCase = "FaultManagement_raiseFault";

		RaiseFault rf = new RaiseFault(action);

		assertEquals(rf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(rf.enterServiceNumber("510284"), true);
		action.getScreenShot(TestCase);
		assertEquals(rf.clickonRaiseFaultbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(rf.enterDataInFieldsToRaiseFault(), true);
		action.getScreenShot(TestCase);
		assertEquals(rf.clickonAccepttbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(rf.raisedFaultNumber(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void manageFaultAddNotes() {
		String TestCase = "FaultManagement_manageFaultAddNotes";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonMaintainFaultnotesactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonAddNotesbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.enterDataInAddNotestextfield("Test"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonAddNotesApplybutton(), true);
		action.getScreenShot(TestCase);

	}

	@Test
	public static void assignFault() {
		String TestCase = "FaultManagement_assignFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber(""), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonAssignFaultactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.selectDepartmentDropdown(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonAssignFaultAssignbutton(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void signoffFault() {
		String TestCase = "FaultManagement_signoffFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00010A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonSignOffactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.selectSignoffDropDowns(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSignOffApplybutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.statusOfFaultNumber(), "Cleared");
		action.getScreenShot(TestCase);
	}

	@Test
	public static void suspendRelease() {
		String TestCase = "FaultManagement_suspendRelease";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonSuspendReleaseactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.selectSuspensionReason(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSuspendbutton(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void upgradeFaultPriority() {
		String TestCase = "FaultManagement_upgradeFaultPriority";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonUpgradeFaultPriorityactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.selectNewPriorityDropdown(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonFaultPriorityAcceptbutton(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void recordFaultTest() {
		String TestCase = "FaultManagement_recordFaultTest";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.selectRecordFaultTestDiagnosisDropDown(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonRecordFaultTestApplybutton(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void printFaultDocket() {
		String TestCase = "FaultManagement_printFaultDocket";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.enterFaultNumber("C00003A"), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonPrintFaultDocketactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.clickonPrintFaultDocketAcceptbutton(), true);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void recordFaultActivity() {
		String TestCase = "FaultManagement_recordFaultActivity";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(TestCase);

		action.getScreenShot(TestCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(TestCase);

		assertEquals(mf.clickonRecordFaultTestactionbutton(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.recordFaultActivitySelectActivityIDActivityNotes(), true);
		action.getScreenShot(TestCase);
		assertEquals(mf.recordFaultActivityRaiseActivityAceeptbutton(), true);
		action.getScreenShot(TestCase);
	}
}
