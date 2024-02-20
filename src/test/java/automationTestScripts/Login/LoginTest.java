package automationTestScripts.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonBussinessScript.LoginPage;
import commonLibraries.Testbase;

public class LoginTest extends Testbase{
//	LoginPage login = new LoginPage(driver);
	
	
	
	
	@Test
	public void loginpage() throws InterruptedException, Throwable {
		
		LoginPage login = new LoginPage(driver);
		
		login.ClickonSiginbtn();
		
		login.enterusername(data.fetchDataFromExcelFile("logindata", 1, 0));
		
		login.Clickonnextbtn();
		
		login.enterpassword(data.fetchDataFromExcelFile("logindata", 1, 1));
		
		login.ClickonSignintoyouraccount();
		
		Thread.sleep(5000);
		
		Assert.assertEquals("Hi, kiran!", login.hometextvalidation());
	}
	

}
