package testScripts.MyAccount;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.DashBoardPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_007 extends TestBase {

	@Test(description = "My Accounts Account details")
	public void TC007_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying My Accounts Account details started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().loginToApplication("akash.srivastava", "AkashSrivastava@1234567890");
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnAccountDetails().changePassword("Akash", "Srivastava");
		TestBase.test.log(Status.INFO, "Test case for verifying My Accounts Account details finished");
	}

}
