package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {
	public static  AndroidDriver<MobileElement> driver;

	public LoginPage(AndroidDriver<MobileElement> driver) {
		LoginPage.driver= driver;
	}

	public static  By btnSignIn=By.xpath("//android.widget.Button[@text='Sign in']");
	public static  By txtUserName=By.className("android.widget.EditText");
	public static  By btnContinue=By.className("android.widget.Button");
	public static  By txtPassword=By.className("android.widget.EditText");
	public static  By btnLogin=By.xpath("//android.widget.Button[@text='Login']");
	
	
	public static MobileElement getSignInOption()
	{
		return driver.findElement(By.xpath("//android.widget.Button[@text='Sign in']"));
	}
	
	public static MobileElement getEnterUserId()
	{
		return driver.findElement(By.className("android.widget.EditText"));
	}
	
	public static MobileElement getContinueOption()
	{
		return driver.findElement(By.className("android.widget.Button"));
	}
	
	public static MobileElement getEnterPassword()
	{
		return driver.findElement(By.className("android.widget.EditText"));
	}
	public static MobileElement clickOnLogin()
	{
		return driver.findElement(By.xpath("//android.widget.Button[@text='Login']"));
	}
}
