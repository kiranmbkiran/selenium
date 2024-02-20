package commonLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class SchedulerImplementation implements ITestListener{
    
   ExtentReports extent = ConfigFiles.extentReportGenerator();
	ExtentTest test;
	
//	  Thread Safe to avoid overriding of TestCases when executed parallel
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
//		 To  store test object in extentTest
		 extentTest.set(test);
		 extentTest.get().log(Status.INFO, result.getName()+" is Started");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, result.getName()+" is Pass");
	}
	
	public void onTestFailure(ITestResult result) {
//		To get test from extentTest  " extentTest.get()=test"
		
		 extentTest.get().fail(result.getThrowable());
		 
//		 Screenshot and attach to report
		 extentTest.get().log(Status.INFO, "Attach screenshot");
					System.out.println("Attach screenshot");
						try {
							extentTest.get().addScreenCaptureFromPath(Screenshot.getSceenshotPath(result.getMethod().getMethodName(),Testbase.driver), result.getMethod().getMethodName());
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println("Screenshot Added");
					extentTest.get().log(Status.INFO, "Screenshot Added");
		
	}
	
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, result.getName()+" is Skipped");
		
	}
	
	public void onFinish(ITestContext result) {
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public static ThreadLocal<ExtentTest> getExtentTest() {
		return extentTest;
	}
	

	

	
	

}
