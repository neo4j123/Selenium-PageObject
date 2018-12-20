package pageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.assertion.AssertionHelper;
import helper.wait.WaitHelper;
import objectRepository.Login_Register_OR;
import testBase.TestBase;

public class Login_RegisterPage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	public WaitHelper wait;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.EMAIL_ADDRESS)
	WebElement emailAddress;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.PASSWORD)
	WebElement password;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.REGISTER_BUTTON)
	WebElement registerButton;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.ERROR_MESSAGE)
	WebElement errorMessage;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.SUCESSFULL_REGISTER_MESSAGE)
	WebElement sucessfullRegistrationMessage;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.LOGIN_EMAIL)
	WebElement loginEmail;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.LOGIN_PASSWORD)
	WebElement loginPassword;

	@CacheLookup
	@FindBy(xpath = Login_Register_OR.LOGIN_BUTTON)
	WebElement loginButton;

	public Login_RegisterPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}

	// TC_001
	public void loginToApplication(String email, String password) {
		loginEmail.sendKeys(email);
		extentReportLog("Filled email");
		loginPassword.sendKeys(password);
		extentReportLog("Filled Password");
		loginButton.click();
		extentReportLog("Clicked on login button");
		AssertionHelper.verifyText(sucessfullRegistrationMessage.getText(),
				Login_Register_OR.SUCESSFULL_REGISTER_MESSAGE_TEXT);
		extentReportLog("Verified that user has logged in");
	}

	// TC_002
	public void invalidUsernamePassword(String email, String password) {
		loginEmail.sendKeys(email);
		extentReportLog("Filled email");
		loginPassword.sendKeys(password);
		extentReportLog("Filled Password");
		loginButton.click();
		extentReportLog("Clicked on login button");
		AssertionHelper.verifyText(errorMessage.getText(), Login_Register_OR.LOGIN_ERROR_TEXT_CORRECT_EMAIL_BLANK_PASSWORD);
		extentReportLog("Verified that error message for incorrect email and incorrect password");
	}

	// TC_003
	public void correctEmailBlankPassword(String email) {
		loginEmail.sendKeys(email);
		extentReportLog("Filled email");
		loginButton.click();
		extentReportLog("Clicked on login button");
		AssertionHelper.verifyText(errorMessage.getText(),
				Login_Register_OR.LOGIN_BLANK_PASSWORD_TEXT);
		extentReportLog("Verified that error message for correct email and blank password");

	}

	// TC_004
	public void emptyUsernameValidPassword(String password) {
		loginPassword.sendKeys(password);
		extentReportLog("Filled Password");
		loginButton.click();
		extentReportLog("Clicked on login button");
		AssertionHelper.verifyText(errorMessage.getText(),
				Login_Register_OR.LOGIN_ERROR_TEXT_BLANK_USERNAME_VALID_PASSWORD);
		extentReportLog("Verified that error message for blank email and valid password");
	}

	// TC_005
	public void blankUsernamePassword() {
		loginButton.click();
		extentReportLog("Clicked on login button");
		AssertionHelper.verifyText(errorMessage.getText(),
				Login_Register_OR.LOGIN_ERROR_TEXT_BLANK_USERNAME_VALID_PASSWORD);
		extentReportLog("Verified that error message for blank email and blank password");

	}

	public void registerWithEmptyEmailPassword() {
		registerButton.click();
		extentReportLog("Clicked  on Register Button");
		AssertionHelper.verifyText(errorMessage.getText(),
				Login_Register_OR.LOGIN_ERROR_TEXT_BLANK_USERNAME_VALID_PASSWORD);
		extentReportLog("Verified the empty email and apssword error message");
	}

	public void registerWithEmptyPassword(String email) {
		emailAddress.sendKeys(email);
		extentReportLog("Filled email in registration form");
		registerButton.click();
		extentReportLog("Clicked on Register Button");
		AssertionHelper.verifyText(errorMessage.getText(), Login_Register_OR.NO_PASSWORD_TEXT);
		extentReportLog("Verified the blank password registration form");
	}

	public void registerWithEmptyEmail(String password) throws InterruptedException {
		this.password.sendKeys(password);
		Thread.sleep(3000);
		emailAddress.click();
		this.password.click();
		Thread.sleep(1000);
		this.password.sendKeys(Keys.SHIFT, Keys.TAB);
		Thread.sleep(500);
		emailAddress.sendKeys(Keys.TAB);
		extentReportLog("Filled password in registration form");
		registerButton.click();
		extentReportLog("Clicked on Register Button");
		AssertionHelper.verifyText(errorMessage.getText(), Login_Register_OR.NO_EMAIL_PASSWORD);
		extentReportLog("Verified the blank email registration form");
	}

	public void registerWithEmailAndPassword(String email, String password) throws InterruptedException {
		emailAddress.sendKeys(email);
		extentReportLog("Filled email in registration form");
		this.password.sendKeys(password);
		extentReportLog("Filled password in registration form");
		emailAddress.click();
		this.password.click();
		while (!(registerButton.isEnabled()) == true) {
			Thread.sleep(1000);
			this.password.sendKeys(Keys.SHIFT, Keys.TAB);
			Thread.sleep(500);
			emailAddress.sendKeys(Keys.TAB);
		}
		registerButton.click();
		extentReportLog("Clicked on Register Button");
		AssertionHelper.verifyText(sucessfullRegistrationMessage.getText(),
				Login_Register_OR.SUCESSFULL_REGISTER_MESSAGE_TEXT);
	}

	public void registerWithAlreadyExistingEmail(String email, String password) throws InterruptedException {
		emailAddress.sendKeys(email);
		extentReportLog("Filled email in registration form");
		this.password.sendKeys(password);
		extentReportLog("Filled password in registration form");
		emailAddress.click();
		this.password.click();
		while (!(registerButton.isEnabled()) == true) {
			Thread.sleep(1000);
			this.password.sendKeys(Keys.SHIFT, Keys.TAB);
			Thread.sleep(500);
			emailAddress.sendKeys(Keys.TAB);
		}
		registerButton.click();
		registerButton.click();
		extentReportLog("Clicked on Register Button");
		AssertionHelper.verifyText(errorMessage.getText(), Login_Register_OR.EXISTING_EMAIL_PASSWORD);
	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
