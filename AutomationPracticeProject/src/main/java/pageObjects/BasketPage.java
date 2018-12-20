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
import objectRepository.BASKET_OR;
import testBase.TestBase;

public class BasketPage {

	private WebDriver driver;
	WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.VIEW_BASKET)
	WebElement addToBasketMessage;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.ITEM_PRICE)
	WebElement viewPrice;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.COUPON_CODE_TEXT_BOX)
	WebElement couponCodeBox;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.COUPON_SUBMIT_BUTTON)
	WebElement couponSubmitButton;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.COUPON_VALIDATE_TEXT)
	WebElement couponText;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.COUPON_ERROR)
	WebElement couponErrorText;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.REMOVE_ITEM)
	WebElement removeProduct;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.REMOVE_ITEM_MESSAGE)
	WebElement removeProductMessage;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.QUANTITY_ITEM)
	WebElement itemQuantity;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.UPDATE_BASKET_BUTTON)
	WebElement updateBasketButton;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.TOTAL_AMOUNT)
	WebElement totalAmount;

	@CacheLookup
	@FindBy(xpath = BASKET_OR.SUBTOTAL_AMOUNT)
	WebElement subTotalAmount;
	
	@CacheLookup
	@FindBy(xpath = BASKET_OR.PROCEED_CHECKOUT_BUTTON)
	WebElement proceedCheckoutButton;

	public BasketPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);
	}

	public void viewBasket(String price) {

		String itemPrice = viewPrice.getText().toString().trim().substring(1,
				(viewPrice.getText().toString().length()));
		AssertionHelper.verifyText(itemPrice, price);
		extentReportLog("User can view that Book in the Menu item with price.");
		extentReportLog(
				"User can add a book by clicking on Add To Basket button which adds that book in to his Basket");

	}

	public void addCoupon(String coupon) {
		couponCodeBox.sendKeys(coupon);
		couponSubmitButton.click();
		extentReportLog("Writing the coupon code and applying it");
		AssertionHelper.verifyText(couponText.getText(), BASKET_OR.COUPON_TEXT);
		extentReportLog(
				"User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page");

	}

	public void minCouponError(String coupon) {
		couponCodeBox.sendKeys(coupon);
		couponSubmitButton.click();
		extentReportLog("Writing the coupon code and applying it");
		String item_price = (couponErrorText.getText()).toString();
		System.out.println("String is : " + item_price);
		String replacedStr = item_price.replace("₹", "");
		System.out.println(replacedStr);
		AssertionHelper.verifyText(replacedStr, BASKET_OR.COUPON_ERROR_TEXT);
		extentReportLog("Verified the coupon error text");

	}

	public void removeProduct(String productName) {
		removeProduct.click();
		AssertionHelper.verifyText(removeProductMessage.getText(), productName + " removed. Undo?");
	}

	public void updateBasket(String quantity) {
		itemQuantity.clear();
		itemQuantity.sendKeys(quantity);
		extentReportLog("Clearing the quantity and inserting the new quantity");
		updateBasketButton.click();
		extentReportLog("Clicking on Update Basket button");
		AssertionHelper.verifyText(removeProductMessage.getText(), BASKET_OR.BASKET_UPDATE_MESSAGE);
		extentReportLog("Verifying the removed product error message");
	}

	public void totalAmountCheck(String totalAmount) {
		AssertionHelper.verifyText(this.totalAmount.getText(), BASKET_OR.TOTAL_AMOUNT_TEXT);
		extentReportLog("Total Amount Verified");
	}

	public void matchSubtotalandTotalAmount() {
		AssertionHelper.verifyText(this.subTotalAmount.getText(), BASKET_OR.SUBTOTAL_AMOUNT_TEXT);
		extentReportLog("Verified that subtotal amount is coming");
		String subTotal_amount = BASKET_OR.SUBTOTAL_AMOUNT_TEXT.toString().trim().substring(1,
				(BASKET_OR.SUBTOTAL_AMOUNT_TEXT.toString().length()));
		String total_Amount = BASKET_OR.TOTAL_AMOUNT_TEXT.toString().trim().substring(1,
				(BASKET_OR.TOTAL_AMOUNT_TEXT.toString().length()));
		double a = Double.parseDouble(subTotal_amount);
		double b = Double.parseDouble(total_Amount);
		if(b>a) {
			extentReportLog("Verified that total amount is greater than subtotal amount");
			System.out.println("Prices Matched");
		}
		
	}
	
	public CheckoutPage goToCheckoutPage() throws IOException {
		proceedCheckoutButton.click();
		extentReportLog("Clicked on Proceed to Checkout button");
		return new CheckoutPage(driver);
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
