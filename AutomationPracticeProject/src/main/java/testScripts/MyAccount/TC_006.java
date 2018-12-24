package testScripts.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_006 extends TestBase{
	
	
	@Test(description = "My Account Orders Editing shipping Address")
	public void TC006_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders Editing shipping Address started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnAddresses().gotoEditShippingAddress().editShippingAddress();
		dp.doLogOut();		
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders Editing shipping Address finished");
	}

}
