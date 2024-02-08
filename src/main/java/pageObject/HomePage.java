package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class HomePage extends AndroidAction {
	
	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/saloonName")
	private WebElement businessName;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/name")
	private WebElement customerName;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/notification")
	private WebElement notificationBell;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private WebElement notificationback;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/book")
	private WebElement bookApt;
	
	public String getBusinessName() {
		return businessName.getText();
	}
	
	public String getCustomerName() {
		return customerName.getText();
	}
	
	public void notificationBell() {
		notificationBell.click();
		notificationback.click();
	}
	
	public ChooseServicePage gotoServiceList() {
		bookApt.click();
		 return new ChooseServicePage(driver);
	}
}
