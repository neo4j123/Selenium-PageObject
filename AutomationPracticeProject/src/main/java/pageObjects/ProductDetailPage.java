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
import objectRepository.PDP_OR;
import testBase.TestBase;

public class ProductDetailPage {

	private WebDriver driver;
	WaitHelper wait;
	boolean flag = false;

	@CacheLookup
	@FindBy(xpath = PDP_OR.PRODUCT_TITLE)
	WebElement product_title;

	@CacheLookup
	@FindBy(xpath = PDP_OR.ADD_TO_BASKET)
	WebElement addToBasketButton;

	@CacheLookup
	@FindBy(xpath = PDP_OR.DESCRIPTION_TAB)
	WebElement descriptionTab;

	@CacheLookup
	@FindBy(xpath = PDP_OR.DESCRIPTION_BOX)
	WebElement descriptionBox;

	@CacheLookup
	@FindBy(xpath = PDP_OR.REVIEW_TAB)
	WebElement reviewTab;

	@CacheLookup
	@FindBy(xpath = PDP_OR.REVIEW_HEADING)
	WebElement reviewHeading;

	@CacheLookup
	@FindBy(xpath = PDP_OR.USER_REVIEW_SECTION)
	WebElement userComments;

	@CacheLookup
	@FindBy(xpath = PDP_OR.NAME_COMMENTS)
	WebElement userCommentsName;

	@CacheLookup
	@FindBy(xpath = PDP_OR.EMAIL_COMMENTS)
	WebElement userCommentsEmail;

	@CacheLookup
	@FindBy(xpath = PDP_OR.SUBMIT_BUTTON_COMMENTS)
	WebElement userCommentsSubmitButton;

	@CacheLookup
	@FindBy(xpath = PDP_OR.ADD_TO_BASKET_MESSAGE)
	WebElement addToBasketMessage;

	@CacheLookup
	@FindBy(xpath = PDP_OR.MENU_ITEM_PRICE)
	WebElement itemPrice;

	public ProductDetailPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);
	}

	public void verifyArrivalImageCheck(String productTitle) {
		AssertionHelper.verifyText(product_title.getText(), productTitle);
		extentReportLog(
				"Testing whether it is navigating to next page where the user can add that book into his basket.");
		AssertionHelper.verifyText(addToBasketButton.getText(), PDP_OR.EXPECTED_ADD_TO_BASKET_BUTTON_TEXT);
		extentReportLog(
				"Image should be clickable and shoul navigate to next page where user can add that book to his basket");
	}

	public void verifyDescriptionText() {
		descriptionTab.click();
		extentReportLog("Clicking on Description tab for the book you clicked on.");
		AssertionHelper.verifyText(descriptionBox.getText(), PDP_OR.DESCRIPTION_TEXT);
		extentReportLog("There should be a description regarding that book the user clicked on");
	}

	public void verifyreviewTab(String comments, String name, String email) {
		reviewTab.click();
		extentReportLog("Clicking on Reviews tab for the book you clicked on.");
		driver.findElement(By.xpath("//p[@class='stars']/span/a[@class='star-1']")).click();
		extentReportLog("Submitting Star Ratings");
		userComments.sendKeys(comments);
		userCommentsName.sendKeys(name);
		userCommentsEmail.sendKeys(email);
		userCommentsSubmitButton.click();
		if (driver.findElements(By.xpath("//ol[@class='commentlist']")).size() > 0) {
			flag = true;
			extentReportLog("There should be a Reviews regarding that book the user clicked on");
		}
		extentReportLog("There should be a Reviews regarding that book the user clicked on");

	}

	public BasketPage addToBakset(String price) throws IOException {
		addToBasketButton.click();
		extentReportLog("Clicking on the Add To Basket button which adds that book to your basket");
		String item_Price = itemPrice.getText().toString().trim().substring(1,
				(itemPrice.getText().toString().length()));
		AssertionHelper.verifyText(item_Price, price);
		extentReportLog("User can view that Book in the Menu item with price.");
		itemPrice.click();
		return new BasketPage(driver);
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
