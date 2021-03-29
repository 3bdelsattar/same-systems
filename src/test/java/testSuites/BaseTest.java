package testSuites;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.RealDevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.linkedinElements;





public class BaseTest {

	public RealDevice driver = null;
	public linkedinElements linkeElement;

 	public void scrollDown() {

		Dimension dimension = driver.driver.manage().window().getSize();		
		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();

		new TouchAction((PerformsTouchActions) driver.driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
	}

	public void scrollLeft(double anchorPercentage){
		Dimension size = driver.driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * 0.9);
		int endPoint = (int) (size.width * 0.05);
		// new TouchAction(driver.driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
		new TouchAction((PerformsTouchActions) driver.driver)
		.press(PointOption.point(startPoint, anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(endPoint, anchor))
		.release().perform();
	}

	public static boolean waitForPresence(AppiumDriver<AndroidElement> driver, int timeLimitInSeconds, AndroidElement element){
		boolean isElementPresent;
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementPresent = element.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}

	}

	public void scroll(int x1 , int y1, int x2 , int y2  ) {

		Dimension dimension = driver.driver.manage().window().getSize();		
		Double scrollHeightStart = dimension.getHeight() * 0.2;
		//		int anchor = (int) (dimension.height * anchorPercentage);



		Double scrollHeightEnd = dimension.getHeight() * 0.2;


		new TouchAction( (PerformsTouchActions) driver.driver)
		.press(PointOption.point(x1, y1))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(x2,y2 ))
		.release().perform();
	}
	
public void dynamicScrollDown(double start, double end) {
		
		Dimension dimension = driver.driver.manage().window().getSize();		
		Double scrollHeightStart = dimension.getHeight() * start;
		int scrollStart = scrollHeightStart.intValue();
		Double scrollHeightEnd = dimension.getHeight() * end;
		int scrollEnd = scrollHeightEnd.intValue();
		new TouchAction((PerformsTouchActions) driver.driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
	}

public String CreatephoneNumber(){
	
	ArrayList<String> arlist = new ArrayList<String>( );
	arlist.add("011");
	arlist.add("012");
	arlist.add("015");
	arlist.add("010");
	
	Random random = new Random();
	String prefix = arlist.get(random.nextInt(arlist.size()));
	
	String number =  Integer.toString(10000000 + random.nextInt(90000000));
	
	String phone = prefix + number;
	return phone;
}


}
