package helper.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import helper.logger.LoggerHelper;

public class ActionHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ActionHelper.class);

	public ActionHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Action Class is initialized");
	}

	/**
	 * This method is used for mouse hover
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	/**
	 * This method is used for matching page title
	 * 
	 * @param expectedTitle
	 */
	public void getPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		log.info("Captured Page Title");
		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("Matched page title actual vs expected and its correct");
	}
}
