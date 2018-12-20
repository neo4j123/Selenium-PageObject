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
import objectRepository.OrderConfirmationPage_OR;
import testBase.TestBase;

public class OrderConfirmationPage {

	private WebDriver driver;
	public WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = OrderConfirmationPage_OR.ORDER_PLACED_MESSAGE)
	WebElement orderMessage;

	@CacheLookup
	@FindBy(xpath = OrderConfirmationPage_OR.PAYMENT_METHOD)
	WebElement orderPaymentMethod;

	@CacheLookup
	@FindBy(xpath = OrderConfirmationPage_OR.BANK_TRANSFER_MESSAGE)
	WebElement orderBankTransferText;

	public OrderConfirmationPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}

	public void verifyOrderPage(String product) {
		AssertionHelper.verifyText(orderMessage.getText(), OrderConfirmationPage_OR.ORDER_PLACED_TEXT);
		extentReportLog("Verified the Order Confirmation text");
		WebElement productName = driver.findElement(By.xpath("//a[contains(text(),'" + product + "')]"));
		AssertionHelper.verifyText(productName.getText(), product);
		extentReportLog("Verified product name in order history");
		AssertionHelper.verifyText(orderPaymentMethod.getText(), OrderConfirmationPage_OR.PAYMENT_METHOD_TEXT);
		extentReportLog("Verified payment method as direct bank transfer");
		AssertionHelper.verifyText(orderBankTransferText.getText(), OrderConfirmationPage_OR.BANK_TRANSFER_TEXT);
		extentReportLog("Verified bank detals statement on order placed page");
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
