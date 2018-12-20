package testScripts.homePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.BasketPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_014 extends TestBase{

	@Test(description = "Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition")
	public void TC014_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		homePage.gotoProduct("Mastering JavaScript");
		ProductDetailPage pdp = new ProductDetailPage(driver);		
		pdp.verifyArrivalImageCheck("Mastering JavaScript");
		pdp.addToBakset("350.00").viewBasket("350.00");	
		BasketPage bp = new BasketPage(driver);
		bp.totalAmountCheck("₹357.00");
		bp.matchSubtotalandTotalAmount();		
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition ended");
	}
}
