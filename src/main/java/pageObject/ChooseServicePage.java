package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class ChooseServicePage extends AndroidAction{
	
	AndroidDriver driver;
	public ChooseServicePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hair Spa']")
	private WebElement hairSpaName;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/option1")
	private WebElement selectProvider;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/option2")
	private WebElement selectDateTime;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/next")
	private WebElement nextBtn;
	
	public void selectService(String selectService) {
		if(hairSpaName.getText().equalsIgnoreCase(selectService)) {
			hairSpaName.click();
		}
	}
	
	
	public void clickNextBtn() {
		nextBtn.click();
	}
	
	public ChooseDateAndTimePage selectDateTime() {
		selectDateTime.click();
		return new ChooseDateAndTimePage(driver);
	}
	
	
	
	
	
	
	

}
