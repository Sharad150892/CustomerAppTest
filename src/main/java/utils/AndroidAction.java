package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAction extends AppiumUtils{
	
	AndroidDriver driver;
	public AndroidAction(AndroidDriver driver)	{
	
		this.driver = driver;
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 3000));
	}

	public void scrollToText(String text) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 0.30));
		} while (canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) {
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//	    "left", 100, "top", 100, "width", 200, "height", 200,
//	    "direction", "left",
//	    "percent", 0.75
//	)); 
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement)ele).getId(),
				    "direction", direction,
				    "percent", 0.10
				));
	}
	
	public void dragDropAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 620,
			    "endY", 555
			));
	}
	
	public void flingeGesture(WebElement ele) {
				
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) ele).getId(),
				    "direction", "down",
				    "speed", 1000
				));
		} while (canScrollMore);
	}

}
