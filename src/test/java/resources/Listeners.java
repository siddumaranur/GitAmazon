package resources;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import testCases.Base;

public class Listeners implements ITestListener {
	public static  AndroidDriver<MobileElement> driver;
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		String s =result.getName();
		try {
			Base.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//Base.captureScreenShot(result, "Skipped");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String s =result.getName();
		try {
			Base.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
