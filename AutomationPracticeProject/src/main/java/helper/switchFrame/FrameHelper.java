package helper.switchFrame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class FrameHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);

	public FrameHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for switching to frame by index	 * 
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("Switching to frame with index: " + index);
	}

	/**
	 * This method is used to switch frame by frameName	 * 
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switching to frame with frameName: " + frameName);
	}

	/**
	 * This method is used to switch frame by WebElement	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switching to frame with WebElement: " + element.toString());
	}
	
	public void switchBackToParentPage() {
		driver.switchTo().defaultContent();
	}

}
