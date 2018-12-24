package testScripts.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_005 extends TestBase{
	
	@Test(description = "My Account Address Functionality viewing billing address and Shipping Address")
	public void TC004_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Address Functionality viewing billing address and Shipping Address started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnAddresses().verifyAddressBillingShipping("Self Akash Srivastava Self Self Delhi - 110001 Delhi", "Self Akash Srivastava Self Self Delhi - 110001 Delhi");
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Address Functionality viewing billing address and Shipping Address finished");
	}


}
