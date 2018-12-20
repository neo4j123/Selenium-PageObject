package testScripts.homePage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.BasketPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_015 extends TestBase{
	
	@Test(description = "Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway")
	public void TC015_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway started");
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
		bp.goToCheckoutPage();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillCustomerDetails("Akash", "Srivastava", "test@test.com", "1234567890");
		checkoutPage.fillAddressDetails("Delhi", "Delhi", "Delhi", "110001");
		checkoutPage.fillCheckoutForm().verifyOrderPage("Mastering JavaScript");;
		
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway ended");
	}

}
