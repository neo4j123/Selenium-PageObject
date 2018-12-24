package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.assertion.AssertionHelper;
import helper.wait.WaitHelper;
import objectRepository.OrderPage_OR;
import testBase.TestBase;

public class OrdersPage {

	private WebDriver driver;
	public WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.Order_Number)
	WebElement orderId;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.order_View_Button)
	WebElement viewOrderButton;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.Customer_Email)
	WebElement orderCustomerEmail;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.Customer_Phone)
	WebElement orderCustomerPhone;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.Billing_Details)
	WebElement orderBillingDetails;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.PAYMENT_METHOD)
	WebElement paymentMethod;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.orderNumber)
	WebElement order_Number;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.orderStatus)
	WebElement order_status;

	@CacheLookup
	@FindBy(xpath = OrderPage_OR.orderDate)
	WebElement dateOfOrder;

	public OrdersPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}

	public void verifyOrder(String orderNumber) {
		AssertionHelper.verifyText((orderId.getText().toString().replaceAll("#", "")), orderNumber);
		extentReportLog("Verified order number");
	}

	public void viewOrderDetails(String orderNumber, String productName, String expectedProductName) {
		verifyOrder(orderNumber);
		extentReportLog("Verified order number");
		viewOrderButton.click();
		extentReportLog("Clicked on view order link");
		String actualProductName = driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]"))
				.getText();
		AssertionHelper.verifyText(actualProductName, expectedProductName);
		extentReportLog("Verified product name is present on order details screen");
	}

	public void verifyCustomerDetailsOrder(String email, String phoneNumber) {
		AssertionHelper.verifyText(orderCustomerEmail.getText(), email);
		extentReportLog("Verified email on order link");
		AssertionHelper.verifyText(orderCustomerPhone.getText(), phoneNumber);
		extentReportLog("Verified user phone number");
	}

	public void verifyBillingDetailsOrder(String billingDetails, String paymentMethod) {
		AssertionHelper.verifyText(orderBillingDetails.getText().toString().replaceAll("[\r\n]+", " "), billingDetails);
		extentReportLog("Verified billing details");
		AssertionHelper.verifyText(this.paymentMethod.getText(), paymentMethod);
		extentReportLog("Verified payment method");
	}

	public void verifyOrderStatusAndDate(String orderNumber, String orderStatus, String orderDate) {
		viewOrderButton.click();
		extentReportLog("Clicked on view order link");
		AssertionHelper.verifyText(order_Number.getText(), orderNumber);
		extentReportLog("Verified order number is present on the screen");
		AssertionHelper.verifyText(order_status.getText(), orderStatus);
		extentReportLog("Verified order status is present on the screen");
		AssertionHelper.verifyText(dateOfOrder.getText(), orderDate);
		extentReportLog("Verified date of order is present on the screen");

	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
