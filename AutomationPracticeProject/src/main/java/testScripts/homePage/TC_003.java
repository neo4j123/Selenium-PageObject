package testScripts.homePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_003 extends TestBase{
	
	@Test(description = "Home page - Images in Arrivals should navigate	")
	public void TC003_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Home page - Images in Arrivals should navigate started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		homePage.gotoProduct("Selenium Ruby");
		ProductDetailPage pdp = new ProductDetailPage(driver);
		pdp.verifyArrivalImageCheck("Selenium Ruby");		
		TestBase.test.log(Status.INFO, "Test case for verifying Home page - Images in Arrivals should navigatefinished");
	}

}
