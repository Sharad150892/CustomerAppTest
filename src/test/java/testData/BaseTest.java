package testData;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObject.ChooseDateAndTimePage;
import pageObject.ChooseServicePage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public ChooseServicePage chooseServicePage;
	public ChooseDateAndTimePage chooseDateAndTimePage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("samsung SM-A146B");
		options.setApp("C:\\Users\\Admin\\eclipse-workspace\\CustomerAppTest\\src\\test\\java\\resources\\CA.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		chooseServicePage = new ChooseServicePage(driver);
		chooseDateAndTimePage = new ChooseDateAndTimePage(driver);
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 3000));
	}

	public void scrollIntoViewAction() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
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
				    "percent", 0.75
				));
	}
	
	public void dragDropAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 620,
			    "endY", 555
			));
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	@AfterClass(alwaysRun=true)
	public void TearDown() {
		driver.quit();
		service.stop();
	}
}
