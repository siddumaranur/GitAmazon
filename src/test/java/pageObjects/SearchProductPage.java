package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchProductPage {

	public static  AndroidDriver<MobileElement> driver;
	public SearchProductPage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	public static  By txtSearch=By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text");
	public static  By expectedElement=By.xpath("//android.widget.ToggleButton[@text='Delivery']");
	public static  By lnkTv=By.xpath("//android.view.View[@text='Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)']");
	public static  By btnAddToCart=By.xpath("//android.widget.Button[@text='Add to Cart']");
	public static  By btnProceedCkt=By.xpath("//android.widget.Button[@text='Proceed to checkout']");
	public static  By btnCart=By.xpath("//android.widget.Button[@text='Cart']");
	public static  By verifyCart=By.xpath("//android.widget.TextView[@text='Added to cart']");
	public static MobileElement editSearch()
	{
		return driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text"));
	}
	
	public static MobileElement clickonTv()
	{
		return driver.findElement(By.xpath("//android.view.View[@text='Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)']"));
	}
	public static MobileElement clickonAddTocart()
	{
		return driver.findElement(By.xpath("//android.widget.Button[@text='Add to Cart']"));
	}
	public static MobileElement clickonCart()
	{
		return driver.findElement(By.xpath("//android.widget.Button[@text='Cart']"));
	}
	public static MobileElement verifyCart()
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Added to cart']"));
	}
	
	public static void ExpectedWaitElement()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Sony Bravia 164 cm (65 inches) 4K Ultra HD Smart Android LED TV 65X7400H (Black) (2020 Model)']")));
	}
	public static void ExpectedWaitTvSize()
	{
		 WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=' Size name: 65 Inches ']")));
	}
	}

