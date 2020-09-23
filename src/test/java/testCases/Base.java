package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static  AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement> getDriver()
	{
		return driver;
	}
	
	public static void  setDriver(AndroidDriver<MobileElement> driver)
	{
		Base.driver=driver;
	}
	
	public static void startServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\startEmulator.bat");
		Thread.sleep(10000);
	}
	
	public static  AndroidDriver<MobileElement> capabilityDriver(String appPackage,String appActivity)throws IOException,MalformedURLException, InterruptedException
	{
			//TODOAuto-generatedmethodstub
		setDriver(driver);
			FileInputStream fileInputStream=new
			FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			String device=properties.getProperty("device");
			 System.out.println(device);
			  if(device.contains("emulator"))
			  {
			  startEmulator();
			  }
			System.out.println("HI");
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
			capabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
			capabilities.setCapability("appPackage",appPackage);
			capabilities.setCapability("appActivity",appActivity);
			driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					System.out.println("ALLCAPABILITIESSET");
				
					return driver;
					}
	
	
	public static void getScreenshot(String s) throws IOException{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
}
