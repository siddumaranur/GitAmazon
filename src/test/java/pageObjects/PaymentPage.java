package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PaymentPage {
	public static  AndroidDriver<MobileElement> driver;
	public PaymentPage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	public static  By chkADDDebit=By.xpath("//android.widget.TextView[@text='Add Debit/Credit/ATM Card']");
	public static  By TxtCardHolderName=By.xpath("//android.widget.EditText[@text='Kiran']");
	public static  By TxtCardNo=By.id("pp-wVYT7P-104");
	public static  By drpSelectMonth=By.id("pp-wVYT7P-108");
	public static  By drpClickMonth=By.id("//android.view.View[@text='4']");
	public static  By drpSelectYear=By.id("pp-wVYT7P-109");
	public static  By drpClickYear=By.id("//android.view.View[@text='2022']");
	public static  By btnAddCardr=By.id("//android.widget.Button[@text='Add your card']");
	public static  By btnContinue=By.xpath("//android.widget.Button[@text='Continue']");
}
