package helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helper.logger.LoggerHelper;

public class DropDownHelper {

	@SuppressWarnings("unused")
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDown object is initialized");
	}

	/**
	 * This method will select dropdown by value
	 * @param element
	 * @param text
	 */
	public void selectUsingValue(WebElement element, String text) {
		Select select = new Select(element);
		log.info("Selecting using value: " + text);
		select.selectByValue(text);
	}

	/**
	 * This method will select dropdown by index
	 * @param element
	 * @param index
	 */
	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("Selecting using index: " + index);
		select.selectByIndex(index);
	}

	/**
	 * This method will select dropdown by visible text
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("Selecting using visible text: " + text);
		select.selectByVisibleText(text);
	}

	/**
	 * This method will deselect dropdown by value
	 * @param element
	 * @param text
	 */
	public void deselectUsingValue(WebElement element, String text) {
		Select select = new Select(element);
		log.info("DeSelecting using visible text: " + text);
		select.deselectByValue(text);		
	}

	/**
	 * This method will deselect dropdown by index
	 * @param element
	 * @param text
	 */
	public void deselectUsingIndex(WebElement element, int text) {
		Select select = new Select(element);
		log.info("DeSelecting using index: " + text);
		select.deselectByIndex(text);
	}

	/**
	 * This method will deselect dropdown by text
	 * @param element
	 * @param text
	 */
	public void deselectUsingText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("DeSelecting using visible text: " + text);
		select.deselectByVisibleText(text);
	}

	/**
	 * This method will deSelectAll
	 * @param element
	 */
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		log.info("DeSelecting All");
		select.deselectAll();
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele: elementList) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}

}
