package testScripts.homePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_004 extends TestBase{
	
	@Test(description = "Home page - Arrivals-Images-Description")
	public void TC004_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Home page - Arrivals-Images-Description started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		homePage.gotoProduct("Selenium Ruby");
		ProductDetailPage pdp = new ProductDetailPage(driver);
		pdp.verifyArrivalImageCheck("Selenium Ruby");
		pdp.verifyDescriptionText();
		TestBase.test.log(Status.INFO, "Test case for verifying Home page - Arrivals-Images-Description ended");
	}

}
