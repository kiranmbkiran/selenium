package commonBussinessScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import commonLibraries.Testbase;

public class LoginPage extends Testbase{
	
	@FindBy(xpath="//a[@class='btn btn-lg btn-wiz-outline-f7941d wizklub-futurz-login-btn py-2 text-nowrap ']")
	 private WebElement signinbtn; 

	@FindBy(xpath="//input[@id='username']")
	 private  WebElement usernamefield;
	
	@FindBy(xpath="//a[@id='action_btn']")
	 private WebElement nxtbtn;
	
	@FindBy(xpath="//input[@id='password']")
	 private WebElement pwdfield;
	
	@FindBy(xpath="//a[@id='action_btn']")
	 private WebElement signintoyouraccount;
	
	
	@FindBy(xpath="//div[@class='page-title']")
	private WebElement hometext;
	
	public void ClickonSiginbtn() {
		signinbtn.click();
	}
	
	public void enterusername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void Clickonnextbtn() {
		nxtbtn.click();
	}
	
	public void enterpassword(String pwd) {
		pwdfield.sendKeys(pwd);
	}
	
	public void ClickonSignintoyouraccount() {
	    signintoyouraccount.click();
	}
	
	
	public LoginPage(WebDriver driver){
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public String hometextvalidation() {
		String home= hometext.getText();
		return home;
		    
	 }

}
	
	


