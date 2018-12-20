package helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	/**
	 * This is a constructor
	 * 
	 * @param driver
	 */
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScript Helper Class has been initialised");
	}

	/**
	 * this method is used for executing javascript
	 * 
	 * @param script
	 * @return
	 */
	public Object executeScript(String script) {
		log.info("Javascript method with script as argument is being called");
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	/**
	 * This method will execute jaavscript with multiple arguments *
	 * 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object... args) {
		log.info("JavaScript method with multiple arguments has been called");
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	/**
	 * This method will scroll to element
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		log.info("Scroll to WebElement");
		executeScript("window.scrollTo(arguments[0], arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	/**
	 * This method will scroll to element and then click
	 * 
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElementAndClick(element);
		element.click();
		log.info("Element is clicked");
	}

	/**
	 * This method will scroll into view
	 * 
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		log.info("Scroll till WebElement");
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This method will scroll into view and then click
	 * 
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		log.info("Scroll to WebElement");
		scrollIntoView(element);
		element.click();
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This method willl scroll vertically
	 * 
	 * @param element
	 */
	public void scrollDownVertically() {
		log.info("Scroll down Vertically full");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * This method will scroll up
	 * 
	 * @param element
	 */
	public void scrollDownHorizontally(WebElement element) {
		log.info("Scroll up full");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	/**
	 * This method is used to scroll by pixel
	 * 
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		log.info("Scroll down by pixel");
		executeScript("window.scrollBY(0," + pixel + ")");
	}

	/**
	 * This method will scroll up by pixel
	 * 
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		log.info("Scroll up by pixel");
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

	/**
	 * This method will be used for zooming in by 100%
	 */
	public void zoomInBy100Percentage() {
		log.info("Zoom in by 100 percentage");
		executeScript("document.body.style.zoom='100%'");
	}

	/**
	 * This method is used for zooming in by 60%
	 */
	public void zoomInBy60Percentage() {
		log.info("Zoom in by 60 percentage");
		executeScript("document.body.style.zoom='60%'");
	}

	/**
	 * This method will be used for clicking on an webelement via JavaScript
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		log.info("Clicking on WebElement via Javascript");
		executeScript("arguments[0].click();", element);
	}

}
