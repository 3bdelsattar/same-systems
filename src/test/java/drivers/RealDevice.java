package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;



//import io.appium.java_client.MobileElement;


public class RealDevice {
	
	public AppiumDriver<AndroidElement> driver = null;
	public DesiredCapabilities dc = new DesiredCapabilities();
	//public RealDevice() throws MalformedURLException 
	public RealDevice() throws Throwable {
		dc.setCapability("udId", "1911b68b");
		dc.setCapability("deviceName", "HD1900");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.linkedin.android");
		dc.setCapability("appActivity", ".authenticator.LaunchActivity");
		dc.setCapability("noReset",true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}	
}
