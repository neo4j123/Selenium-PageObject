package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.assertion.AssertionHelper;
import helper.wait.WaitHelper;
import objectRepository.HomePage_OR;
import objectRepository.Login_Register_OR;
import testBase.TestBase;

public class HomePage {

	private WebDriver driver;
	WaitHelper wait;
	int count = 0;

	@CacheLookup
	@FindBy(xpath = HomePage_OR.SHOP_LINK)
	WebElement shopLink;

	@CacheLookup
	@FindBy(xpath = HomePage_OR.SLIDER)
	List<WebElement> slider;

	@CacheLookup
	@FindBy(xpath = HomePage_OR.ARRIVALS)
	List<WebElement> arrivals;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.MY_ACCOUNT)
	WebElement myAccountMenu;

	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);
		wait.waitForElement(shopLink, 5);
	}

	/**
	 * This method will be used for clicking on one of the product in Arrivals
	 * 
	 * @return
	 * @throws IOException
	 */
	public ProductDetailPage gotoProduct(String productName) throws IOException {
		driver.findElement(By.xpath("//img[contains(@title,'" + productName + "')]")).click();
		extentReportLog("Clicking on the image in the Arrivals");
		return new ProductDetailPage(driver);
	}

	/**
	 * This method will click on Shop Link
	 * 
	 * @throws IOException
	 */
	public ShopPage clickOnShopLink() throws IOException {
		shopLink.click();
		extentReportLog("Clicking on Shop Menu");
		return new ShopPage(driver);
	}

	public void getSlidersCount() {
		extentReportLog("Testing whether the Home page has Three Sliders only");
		for (int i = 0; i < slider.size(); i++) {
			count++;
		}
		AssertionHelper.verifyCount(count, slider.size());
		extentReportLog("The Home page must contains only three sliders" + count);
	}

	public void getArrivalsCount() {
		extentReportLog("Testing whether the Home page has Three Arrivals only");
		for (int i = 0; i < arrivals.size(); i++) {
			count++;
		}
		AssertionHelper.verifyCount(count, arrivals.size());
		extentReportLog("The Home page must contains only three Arrivals" + count);
	}

	public Login_RegisterPage goToMyAccountPage() throws IOException {
		myAccountMenu.click();
		extentReportLog("Clicked on My Account Menu");
		return new Login_RegisterPage(driver);
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
