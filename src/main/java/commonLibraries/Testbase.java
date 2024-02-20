package commonLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Testbase {
    
	/**
	 * commonLibraries object creation
	 */
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;	

//	public DriverScripts d = new DriverScripts();
	
	public FileData  data= new FileData();
	
	
	
	public Testbase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					//"G:\\wizklub\\src\\main\\java\\com\\wizklub\\qa\\config\\config.properties");
					".\\src\\main\\java\\wizklubconfig\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	
  //	@Parameters("browser")
	    @BeforeClass
	    public void launchBrowser() {
	    	//To CrossBrowser execution unComment @Parameters and add argument as String browser & comment below line
	    	
	        String browserName = prop.getProperty("browser");
	           System.out.println(browserName);

	        if (browserName.equals("firefox")) {
	       
	            System.setProperty("webdriver.gecko.driver", "E:\\sellenium\\geckodriver.exe");
	          //  WebDriverManager.firefoxdriver().setup();
	               driver = new FirefoxDriver();
	        
	        } else if (browserName.equals("chrome")) {
	        
	           System.setProperty("webdriver.chrome.driver", "E:\\sellenium\\chromedriver\\chromedriver.exe");
	           // WebDriverManager.chromedriver().setup();
	               driver = new ChromeDriver();
	        }
              System.out.println(driver);
	 //       driver.manage().window().maximize();
	    //    driver.manage().deleteAllCookies();
	        driver.get(prop.getProperty("url"));
	    }
	    
	    
//	    @BeforeMethod
//		public void loginApplication() throws Throwable 
//		{
//			//ScreenRecorderUtil.startRecord("testRecord");
//			/*Login to Application*/
//	          commonBussinessScript.LoginPage 	Loginpage=new commonBussinessScript.LoginPage(driver);
//			  Loginpage.Loginpage(prop.getProperty("username"), prop.getProperty("pwd"));
//			 // d.waitForPagetoLoad(driver);
//		}  
	    
//	    @BeforeSuite
	public static  ExtentReports extentReportGenerator()
		{
		//	ExtentReports , ExtentSparkReporter 2 classes required 
		//	ScreenRecorderUtil.deleteRecords();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);  
		
		String path ="./Reports/"+"ExtentReport_"+currentDate+".html";
			
	   //		ExtentSparkReporter
		
		extent = new ExtentReports();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
			reporter.config().setReportName(" Wizklub");
		reporter.config().setDocumentTitle(" Test Results");
			
	//	ExtentReports
		
		extent.setSystemInfo("Tester", "kiran");
		extent.attachReporter(reporter);
					return extent;
         }
}
