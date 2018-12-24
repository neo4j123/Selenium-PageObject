package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.wait.WaitHelper;
import objectRepository.AccountDetails_OR;
import testBase.TestBase;

public class AccountDetailsPage {

	private WebDriver driver;
	public WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = AccountDetails_OR.FIRST_NAME)
	WebElement first_name;

	@CacheLookup
	@FindBy(xpath = AccountDetails_OR.LAST_NAME)
	WebElement last_name;

	@CacheLookup
	@FindBy(xpath = AccountDetails_OR.SAVE_CHANGES_BUTTON)
	WebElement saveChangesButton;

	public AccountDetailsPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}

	public void changePassword(String firstName, String lastName) {
		first_name.clear();
		first_name.sendKeys(firstName);
		extentReportLog("Filled first name");
		last_name.clear();
		last_name.sendKeys(lastName);
		extentReportLog("Filled last name");
		saveChangesButton.click();
		extentReportLog("Clicked on save changes button");
	}
	
	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
