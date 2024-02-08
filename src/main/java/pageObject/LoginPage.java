package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class LoginPage extends AndroidAction{
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/emailEditText")
	private WebElement email;
	
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/passwordEditText")
	private WebElement password;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/loginButton")
	private WebElement logIn;
	
	@AndroidFindBy(id="com.hubwallet.customerbooknpay:id/salonName")
	private WebElement salonName;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	private WebElement allow;
//	
//	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
//	private String permissionToast;
	
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void loginClick() {
		logIn.click();
	}
	
	public void selectSalon(String salon) {
		
		if(salonName.getText().equalsIgnoreCase(salon)) {
			salonName.click();
		}
	}
	
	public HomePage allowButton() {
		allow.click();
		return new HomePage(driver);
	}

}
