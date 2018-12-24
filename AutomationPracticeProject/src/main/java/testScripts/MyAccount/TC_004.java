package testScripts.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_004 extends TestBase{
	
	@Test(description = "My Account Orders verifying order date and order status")
	public void TC004_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders verifying order date and order status started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnOrderLink().verifyOrderStatusAndDate("778", "On Hold", "December 20, 2018");
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders verifying order date and order status finished");
	}

}
