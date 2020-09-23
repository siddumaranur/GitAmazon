package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.CartPage;
import pageObjects.SearchProductPage;
import resources.TestData;
import utilities.utility;

public class SearchProduct extends Base{
	@DataProvider
	public String[][]getExcelData()throws InvalidFormatException,IOException{
	TestData read=new TestData();
	return
	read.getCellData(System.getProperty("user.dir")+"\\src\\main\\java\\productData.xlsx","productName");
	}
	
	
	@Test(dataProvider = "getExcelData")
	public void searchProduct(String product) throws IOException, InterruptedException
	{
	setDriver(driver);
	startServer();
FileInputStream fileInputStream=new
FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
Properties properties=new Properties();
properties.load(fileInputStream);
String appPackage=properties.getProperty("amazonPackage");
String appActivity=properties.getProperty("amazonActivity");


AndroidDriver<MobileElement>driver=capabilityDriver(appPackage,appActivity);
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
Base.setDriver(driver);

Logger log=LogManager.getLogger(SearchProduct.class);
log.info("Launching Aamzon Application");
SearchProductPage sp=new SearchProductPage(driver);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.pressKey(new KeyEvent(AndroidKey.ENTER));



driver.hideKeyboard();
log.info("Entering Product Name");
SearchProductPage.editSearch().sendKeys(product);
driver.pressKey(new KeyEvent(AndroidKey.ENTER));



Thread.sleep(10000);
log.info("Page Loding....");
//SearchProductPage.ExpectedWaitElement();
utility utl=new utility(driver);
log.info("Searching Product");
utility.scrollToTillProduct();
List productList =driver.findElements(By.className("android.view.View"));
System.out.println(productList.size());
Random rnd = new Random();
int rndInt = rnd.nextInt(productList.size());
System.out.println(rndInt);
log.info("Click on product");
System.out.println("Selecting the product");
((org.openqa.selenium.WebElement) productList.get(rndInt)).click();

 Thread.sleep(10000);

 log.info("verifying Product Size");
	//SearchProductPage.ExpectedWaitTvSize();
 //utility.scrollToTillPrice();
// String productName=driver.findElement(By.id("bylineInfo")).getText();
// System.out.println(productName);
	//String tvSize=driver.findElement(By.xpath("//android.widget.Button[@text='Size name: 65 Inches']")).getText();
//	System.out.println(tvSize);
	

System.out.println("Adding the product to cart");
utility.scrollToTillPrice();
utility.scrollToTillAddToCart();
//String totalprice=driver.findElement(By.id("tp_price_block_total_price_in")).getText();
//System.out.println(totalprice);
log.info("click on Add To Cart");

 SearchProductPage.clickonAddTocart().click();
 Thread.sleep(10000);
String verifycart= SearchProductPage.verifyCart().getText();
Assert.assertEquals("Added to cart", verifycart); 
  System.out.println(verifycart);
	  System.out.println("product added to cart successfully");
	  log.info("click on cart");
	  SearchProductPage.clickonCart().click();
	  CartPage cp=new CartPage(driver);
	  
	  log.info("click on proceed to Buy");
	  CartPage.clickonProcedToBuy().click();
 
	
}
	

}


