package pageObjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.select.DropDownHelper;
import helper.wait.WaitHelper;
import objectRepository.CheckOutPage_OR;
import testBase.TestBase;

public class CheckoutPage {

	private WebDriver driver;
	public WaitHelper wait;
	public DropDownHelper dropDown;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.FIRST_NAME)
	WebElement billingFirstName;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.LAST_NAME)
	WebElement billingLastName;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.EMAIL_ADDRESS)
	WebElement billingEmail;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.PHONE_NUMBER)
	WebElement billingPhoneNumber;
	
	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.STREET_ADDRESS)
	WebElement billingStreetAddress;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.TOWN)
	WebElement billingTown;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.POSTCODE)
	WebElement billingPostalCode;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.STATE)
	WebElement billingState;

	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.PLACE_ORDER)
	WebElement billingPlaceOrderButton;
	
	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.STATE_VALUE)
	WebElement billingStateValue;
	
	@CacheLookup
	@FindBy(xpath = CheckOutPage_OR.STATE_TEXT_BOX)
	WebElement billingStateBox;

	public CheckoutPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);
		dropDown = new DropDownHelper(driver);
	}

	public void fillCustomerDetails(String firstName, String lastName, String email, String phoneNumber) {
		billingFirstName.sendKeys(firstName);
		billingLastName.sendKeys(lastName);
		billingEmail.sendKeys(email);
		billingPhoneNumber.sendKeys(phoneNumber);
		extentReportLog("Filled Customer Details like: firstname, lastname, email, phonenumber");
	}

	public void fillAddressDetails(String street, String town, String state, String postalCode) {		
		billingStreetAddress.sendKeys(street);
		billingTown.sendKeys(town);
		billingState.click();
		billingStateBox.sendKeys("Delhi");
		billingStateValue.click();
		billingPostalCode.sendKeys(postalCode);
		extentReportLog("Filled Billing details like street, town, State, postalCode");
	}

	public OrderConfirmationPage fillCheckoutForm() throws IOException {
		billingPlaceOrderButton.click();
		extentReportLog("Clicked on Place order button");
		return new OrderConfirmationPage(driver);
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
