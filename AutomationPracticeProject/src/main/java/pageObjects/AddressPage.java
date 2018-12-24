package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import helper.assertion.AssertionHelper;
import helper.wait.WaitHelper;
import objectRepository.AddressPage_OR;
import testBase.TestBase;

public class AddressPage {
	
	private WebDriver driver;
	public WaitHelper wait;
	
	@CacheLookup
	@FindBy(xpath=AddressPage_OR.BILLING_ADDRESS)
	WebElement billingAddress;
	
	@CacheLookup
	@FindBy(xpath=AddressPage_OR.SHIPPING_ADDRESS)
	WebElement shippingAddress;
	
	@CacheLookup
	@FindBy(xpath=AddressPage_OR.EDIT_SHIPPING_ADDRESS)
	WebElement editShippingAddress;
	
	@CacheLookup
	@FindBy(xpath=AddressPage_OR.EDIT_BILLING_ADDRESS)
	WebElement editBillingAddress;
	
	
	public AddressPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}
	
	public void verifyAddressBillingShipping(String shippingAddress, String billingAddress) {
		AssertionHelper.verifyText(this.billingAddress.getText().toString().replaceAll("[\r\n]+", " "), shippingAddress);
		extentReportLog("Verified the billing address");
		AssertionHelper.verifyText(this.shippingAddress.getText().toString().replaceAll("[\r\n]+", " "), billingAddress);
		extentReportLog("Verified the shipping address");
	}
	
	public EditBillingAddressPage gotoEditBillingAddress() throws IOException {
		editBillingAddress.click();
		extentReportLog("Clicked on Edit button for billing address");
		return new EditBillingAddressPage(driver);
	}
	
	public EditShippingAddressPage gotoEditShippingAddress() throws IOException {
		editShippingAddress.click();
		extentReportLog("Clicked on Edit button for shipping address");
		return new EditShippingAddressPage(driver);
	}
	
	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
