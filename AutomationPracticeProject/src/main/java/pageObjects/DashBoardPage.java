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
import objectRepository.DashboardPage_OR;
import testBase.TestBase;

public class DashBoardPage {

	private WebDriver driver;
	public WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.LOGOUT_LINK)
	WebElement logOutLink;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.ACCOUNTDETAILS_LINK)
	WebElement accountDetailsLink;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.ADDRESSES_LINK)
	WebElement addressesLink;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.DOWNLOADS_LINK)
	WebElement downloadsLink;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.ORDERS_LINK)
	WebElement ordersLink;

	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.DASHBOARD_LINK)
	WebElement dashboardLink;
	
	@CacheLookup
	@FindBy(xpath = DashboardPage_OR.DashboardTextLocator)
	WebElement dashboardText;

	public DashBoardPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}

	public void clickOnDashboardLink() {
		dashboardLink.click();
		extentReportLog("Clicked on dashboard link");
		AssertionHelper.verifyText(dashboardText.getText(), DashboardPage_OR.Dashboard_Text);
		extentReportLog("Verified that dashboard page is opened");
		
	}

	public OrdersPage clickOnOrderLink() throws IOException {
		ordersLink.click();
		extentReportLog("Clicked on order link");
		return new OrdersPage(driver);
	}

	public void clickOnDownloadsLink() {
		downloadsLink.click();
		extentReportLog("Clicked on Downloads link");
	}

	public AddressPage clickOnAddresses() throws IOException {		
		addressesLink.click();
		extentReportLog("Clicked on Addresses link");
		return new AddressPage(driver);
	}

	public AccountDetailsPage clickOnAccountDetails() throws IOException {
		accountDetailsLink.click();
		extentReportLog("Clicked on Account Details link");
		return new AccountDetailsPage(driver);
	}

	public void doLogOut() {
		logOutLink.click();
		extentReportLog("Clicked on Log out link");
	}
	
	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
