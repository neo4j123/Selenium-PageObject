package testScripts.homePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001 extends TestBase {

	@Test(description = "This test case will home page with 3 sliders only")
	public void TC001_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying home page sliders started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getSlidersCount();
		TestBase.test.log(Status.INFO, "Test case for verifying home page sliders finished");
	}

}
