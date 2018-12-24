package testScripts.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import pageObjects.OrdersPage;
import testBase.TestBase;

public class TC_003 extends TestBase {

	@Test(description = "My Accounts - Dashboard")
	public void TC003_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders verifying details started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnOrderLink().viewOrderDetails("778", "Android Quick Start Guide", "Android Quick Start Guide");
		OrdersPage op = new OrdersPage(driver);
		op.verifyCustomerDetailsOrder("akash.srivastava@sourcefuse.com", "8377878847");
		op.verifyBillingDetailsOrder("Self Akash Srivastava Self Self Delhi - 110001 Delhi", "Direct Bank Transfer");
		TestBase.test.log(Status.INFO, "Test case for verifying My Account Orders verifying details finished");
	}

}
