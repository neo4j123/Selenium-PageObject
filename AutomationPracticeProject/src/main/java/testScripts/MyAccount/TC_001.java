package testScripts.MyAccount;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001 extends TestBase{
	
	@Test(description = "My Accounts - Dashboard")
	public void TC001_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Accounts - Dashboard started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnDashboardLink();
		TestBase.test.log(Status.INFO, "Test case for verifying My Accounts - Dashboard finished");
	}


}
