package testCases;


	

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.TestData;

	public class LoginTest extends Base {
		@DataProvider
		public String[][]getExcelData()throws InvalidFormatException,IOException{
		TestData read=new TestData();
		return
		read.getCellData(System.getProperty("user.dir")+"\\src\\main\\java\\CredData.xlsx","CredData");
		}
		
		
		@Test(dataProvider = "getExcelData")
	public void signIn(String username,String password) throws IOException, InterruptedException {
			Logger log=LogManager.getLogger(LoginTest.class);
	System.out.println("test is starting");
	FileInputStream fileInputStream=new
			FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			String appPackage=properties.getProperty("amazonPackage");
			String appActivity=properties.getProperty("amazonActivity");
			startServer();
			driver=capabilityDriver(appPackage,appActivity);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			Base.setDriver(driver);
	    LoginPage signin =new LoginPage(driver); //sending driver in the pageobject class
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.btnSignIn));//wait until signin option comes
	    log.info("click on sign in");
	    LoginPage.getSignInOption().click();
	    
	    log.info("pageLoading....");
	    wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.txtUserName));//wait until userid option comes
	    log.info("enter username ");
	    LoginPage.getEnterUserId().sendKeys(username);//userid entered
	    driver.hideKeyboard();
	    
	    log.info(" click on continue button");
	    LoginPage.getContinueOption().click();//continue
	    Thread.sleep(5000);
	    
	    log.info("enter password..");
	    LoginPage.getEnterPassword().sendKeys(password);//enter password
	    driver.hideKeyboard();
	    
	    log.info("click on continue button");
	    LoginPage.getContinueOption().click();//continue
	    System.out.println("sign-in successfully");
	    log.info("signed in amazon test case passed");
	    
	  //  stopServer();
	}
		

}
