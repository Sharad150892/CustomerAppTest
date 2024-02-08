package testData;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void performLogin() throws InterruptedException {
		loginPage.enterEmail("narmsync.test@gmail.com");
		loginPage.enterPassword("12345678");
		loginPage.loginClick();
		Thread.sleep(2000);
		loginPage.selectSalon("Look's Salon");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void verifyHomePage() throws InterruptedException {
		homePage = loginPage.allowButton();
		String business = homePage.getBusinessName();
		Assert.assertEquals(business, "Look's Salon");
		String customer = homePage.getCustomerName();
		Assert.assertEquals(customer, "Hi Nick");
		homePage.notificationBell();
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void verifySeviceListPage() throws InterruptedException {
		chooseServicePage =  homePage.gotoServiceList();
		chooseServicePage.selectService("Hair Spa");
		chooseServicePage.clickNextBtn();
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void verifyDateAndTimePage() throws InterruptedException {
		chooseDateAndTimePage = chooseServicePage.selectDateTime();
		chooseDateAndTimePage.selectDate("8:00 PM");
		Thread.sleep(3000);
		chooseDateAndTimePage.nextButton();
		Thread.sleep(5000);
	}
}
