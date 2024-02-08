package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class ChooseDateAndTimePage extends AndroidAction{

	AndroidDriver driver;
	public ChooseDateAndTimePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@text='26']")
//	private WebElement selectDate;

	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/time")
	private List<WebElement> selectTime;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='NEXT']")
	private WebElement nextBtn;
	
	public void selectDate(String time) {
		
		for(WebElement selectTimes : selectTime ) {
			if(selectTimes.getText().equals(time)) {
				selectTimes.click();
			}
		}
	}
	
	public void nextButton() {
		nextBtn.click();
	}
	
	
	
}
