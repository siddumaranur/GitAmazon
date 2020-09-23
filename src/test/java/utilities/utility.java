package utilities;

import java.time.Duration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class utility {
	public static AndroidDriver<MobileElement> driver;

	public utility(AndroidDriver<MobileElement> driver) {
		utility.driver= driver;
	}
	
	public static void scrollToTillProduct()
	{
		
		TouchAction act=new TouchAction(driver);
		 act.press(PointOption.point(443, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300))).moveTo(PointOption.point(516, 641)).release().perform();
	}
	
	public static void scrollToTillPrice()
	{
		TouchAction act=new TouchAction(driver);

		 act.press(PointOption.point(512, 1786)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300))).moveTo(PointOption.point(511, 638)).release().perform();
	}
	public static void scrollToTillAddToCart()
	{
		TouchAction act=new TouchAction(driver);

		 act.press(PointOption.point(512, 2043)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300))).moveTo(PointOption.point(511, 690)).release().perform();
	}
}
