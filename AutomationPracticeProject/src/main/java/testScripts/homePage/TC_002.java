package testScripts.homePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_002 extends TestBase {

	@Test(description = "This test case will verify Home page with three Arrivals only")
	public void TC002_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying home page Arrivals started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		TestBase.test.log(Status.INFO, "Test case for verifying home page Arrivals finished");
	}

}
