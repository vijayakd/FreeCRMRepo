package pack.crm.testcases;

import org.testng.TestNG;

import pack.crm.ExtentreportListener.ExtentreportListener;

public class FreeCRMTestRunner {

	public static void main(String[] args) {

		TestNG testNG = null;
		testNG= new TestNG();
		
		ExtentreportListener ext = new ExtentreportListener();
		
		testNG.setTestClasses(new Class[] {LoginPageTest.class});
		
		testNG.addListener(ext);
		
		testNG.run();
		
		
	}

}
