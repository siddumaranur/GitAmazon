package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {
	public static  AndroidDriver<MobileElement> driver;
	public CartPage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	public static  By btnProcdToBuy=By.xpath("//android.widget.Button[@text='Proceed to Buy']");
	public static  By btnContinue=By.xpath("//android.widget.Button[@text='Continue']");
	
	public static MobileElement clickonProcedToBuy()
	{
		return driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to Buy']"));
	}
}
