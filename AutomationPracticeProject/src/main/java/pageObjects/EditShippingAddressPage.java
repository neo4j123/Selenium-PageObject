package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.wait.WaitHelper;
import objectRepository.EditShippingDetails_OR;
import testBase.TestBase;

public class EditShippingAddressPage {
	
	private WebDriver driver;
	public WaitHelper wait;
	
	@CacheLookup
	@FindBy(xpath=EditShippingDetails_OR.BILLING_POSTAL_CODE)
	WebElement postalCode;
	
	@CacheLookup
	@FindBy(xpath=EditShippingDetails_OR.SAVE_SHIPPING_ADDRESS)
	WebElement saveAddress;
	
	public EditShippingAddressPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}
	
	public void editShippingAddress() {
		postalCode.clear();
		postalCode.sendKeys("111001");
		extentReportLog("Filling up the postal code");
		saveAddress.click();
		extentReportLog("Clicked on save address button");
	}
	
	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
