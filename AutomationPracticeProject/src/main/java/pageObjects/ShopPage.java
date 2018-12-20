package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import helper.select.DropDownHelper;
import helper.wait.WaitHelper;
import objectRepository.ShopPage_OR;
import testBase.TestBase;

public class ShopPage {

	private WebDriver driver;
	WaitHelper wait;
	int counter = 0;
	int notFound = 0;
	DropDownHelper dropDown;
	VerificationHelper verify;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.HOME_LINK)
	WebElement homeLink;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.SHOP_LINK)
	WebElement shopLink;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.minPriceProduct)
	WebElement filterMinValue;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.sliderLeftToRight)
	WebElement filterSliderleftToRight;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.fromPrice)
	WebElement minFilterPrice;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.maxPriceProduct)
	WebElement filterMaxValue;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.sliderRightToLeft)
	WebElement filterSliderRightToLeft;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.filterButtonProduct)
	WebElement applyFilterButton;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.SalePriceBooks)
	List<WebElement> saleBooks;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.WithoutSaleBooks)
	List<WebElement> withoutSaleBooks;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.PRODUCT_CATEGORY_FILTER_COUNT)
	WebElement productFilterCount;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.PRODUCT_LIST)
	List<WebElement> productList;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.ORDER_BY)
	WebElement orderBy;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.OUT_OF_STOCK_PRODUCT)
	WebElement outOfStockProduct;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.OUT_OF_STOCK_MESSAGE)
	WebElement outStockMessage;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.SALE_PRICE)
	WebElement salePrice;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.ACTUAL_PRICE)
	WebElement withoutSalePrice;

	@CacheLookup
	@FindBy(xpath = ShopPage_OR.SALE_PRODUCT)
	WebElement productOnSale;

	public ShopPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);
		dropDown = new DropDownHelper(driver);
		verify = new VerificationHelper(driver);
	}

	public void checkSaleAndNormalPrices() {
		productOnSale.click();
		extentReportLog("Clicked on sale product");
		verify.isDisplayed(salePrice);
		extentReportLog("Sale Price is getting displayed");
		verify.isDisplayed(withoutSalePrice);
		extentReportLog("Without Sale price is also getting displayed");
	}

	public void checkOutOfStockOption(String text) {
		outOfStockProduct.click();
		extentReportLog("Clicked on out of stock product");
		AssertionHelper.verifyText(outStockMessage.getText(), text);
		extentReportLog("Out of stock text is verified");
	}

	public void sortingByNewnessRating() {
		ArrayList<String> expectedSortedList = new ArrayList<String>();
		ArrayList<String> actualSortedList = new ArrayList<String>();
		expectedSortedList.add("Functional Programming in JS");
		expectedSortedList.add("Selenium Ruby");
		expectedSortedList.add("Mastering JavaScript");
		expectedSortedList.add("Android Quick Start Guide");
		expectedSortedList.add("JS Data Structures and Algorithm");
		expectedSortedList.add("HTML5 WebApp Develpment");
		expectedSortedList.add("HTML5 Forms");
		expectedSortedList.add("Thinking in HTML");

		dropDown.selectByVisibleText(orderBy, "Sort by newness");
		List<WebElement> totalProducts = driver.findElements(By.xpath("//ul[@class='products masonry-done']/li/a/h3"));
		System.out.println(totalProducts.size());
		for (int i = 1; i <= totalProducts.size(); i++) {

			actualSortedList.add(
					driver.findElement(By.xpath("//ul[@class='products masonry-done']/li[" + i + "]/a/h3")).getText());

		}

		for (int i = 0; i < expectedSortedList.size(); i++) {
			if (expectedSortedList.contains(actualSortedList.get(i))) {
				extentReportLog("Exist : " + actualSortedList.get(i));
			} else {
				extentReportLog("Not Exist : " + actualSortedList.get(i));
			}
		}

		boolean flag = expectedSortedList.equals(actualSortedList);
		if (flag == true) {
			extentReportLog("Sorting by Popularity is sucessfull");
		} else {
			extentReportLog("Sorting by Popularity is unsucessfull");
		}

	}

	public void sortingByAverageRating() {
		ArrayList<String> expectedSortedList = new ArrayList<String>();
		ArrayList<String> actualSortedList = new ArrayList<String>();
		expectedSortedList.add("Functional Programming in JS");
		expectedSortedList.add("Selenium Ruby");
		expectedSortedList.add("Mastering JavaScript");
		expectedSortedList.add("Android Quick Start Guide");
		expectedSortedList.add("JS Data Structures and Algorithm");
		expectedSortedList.add("HTML5 WebApp Develpment");
		expectedSortedList.add("HTML5 Forms");
		expectedSortedList.add("Thinking in HTML");

		dropDown.selectByVisibleText(orderBy, "Sort by average rating");
		List<WebElement> totalProducts = driver.findElements(By.xpath("//ul[@class='products masonry-done']/li/a/h3"));
		System.out.println(totalProducts.size());
		for (int i = 1; i <= totalProducts.size(); i++) {

			actualSortedList.add(
					driver.findElement(By.xpath("//ul[@class='products masonry-done']/li[" + i + "]/a/h3")).getText());

		}

		for (int i = 0; i < expectedSortedList.size(); i++) {
			if (expectedSortedList.contains(actualSortedList.get(i))) {
				extentReportLog("Exist : " + actualSortedList.get(i));
			} else {
				extentReportLog("Not Exist : " + actualSortedList.get(i));
			}
		}

		boolean flag = expectedSortedList.equals(actualSortedList);
		if (flag == true) {
			extentReportLog("Sorting by Popularity is sucessfull");
		} else {
			extentReportLog("Sorting by Popularity is unsucessfull");
		}

	}

	public void sortingByPopularity() {
		ArrayList<String> expectedSortedList = new ArrayList<String>();
		ArrayList<String> actualSortedList = new ArrayList<String>();
		expectedSortedList.add("Selenium Ruby");
		expectedSortedList.add("Mastering JavaScript");
		expectedSortedList.add("Functional Programming in JS");
		expectedSortedList.add("Android Quick Start Guide");
		expectedSortedList.add("Thinking in HTML");
		expectedSortedList.add("HTML5 Forms");
		expectedSortedList.add("JS Data Structures and Algorithm");
		expectedSortedList.add("HTML5 WebApp Develpment");

		dropDown.selectByVisibleText(orderBy, "Sort by popularity");
		List<WebElement> totalProducts = driver.findElements(By.xpath("//ul[@class='products masonry-done']/li/a/h3"));
		System.out.println(totalProducts.size());
		for (int i = 1; i <= totalProducts.size(); i++) {

			actualSortedList.add(
					driver.findElement(By.xpath("//ul[@class='products masonry-done']/li[" + i + "]/a/h3")).getText());

		}

		for (int i = 0; i < expectedSortedList.size(); i++) {
			if (expectedSortedList.contains(actualSortedList.get(i))) {
				extentReportLog("Exist : " + actualSortedList.get(i));
			} else {
				extentReportLog("Not Exist : " + actualSortedList.get(i));
			}
		}

		boolean flag = expectedSortedList.equals(actualSortedList);
		if (flag == true) {
			extentReportLog("Sorting by Popularity is sucessfull");
		} else {
			extentReportLog("Sorting by Popularity is unsucessfull");
		}

	}

	public void clickProductCategoryFilter(String productName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
		int expectedProductCount = Integer.parseInt(productFilterCount.getText().replaceAll("\\p{P}", ""));
		int actualProductCount = productList.size();
		if (expectedProductCount == actualProductCount) {
			extentReportLog("The count in the filter is matching with the count of total products shown");
		} else {
			extentReportLog("The count in the filter is not matching with the count of total products shown");
		}

	}

	/**
	 * This method clicks home link from shop page
	 * 
	 * @return
	 * @throws IOException
	 */
	public HomePage clickOnHomeLink() throws IOException {
		homeLink.click();
		extentReportLog("Clicking on Home menu button");
		return new HomePage(driver);
	}

	public void viewBookMinMaxPrice(int minPrice, int maxPrice) {

		int toPrice = Integer.parseInt(filterMinValue.getText().replace("₹", ""));

		boolean flagOne = true;
		if (toPrice >= 150) {
			while (flagOne) {

				if (toPrice == minPrice) {
					break;
				} else {

					int count1 = 1;
					Actions action2 = new Actions(driver);
					action2.dragAndDropBy(filterSliderleftToRight, count1 + 1, 0).build().perform();

					int PriceAfterDrag = Integer.parseInt(minFilterPrice.getText().replace("₹", ""));

					if (PriceAfterDrag == minPrice) {
						flagOne = false;
						break;
					} else {
						continue;
					}

				}
			}

		}
		extentReportLog("Moving slider from left to right");

		int frompriceWithoutSymbol = Integer.parseInt(filterMaxValue.getText().replace("₹", ""));

		boolean flag = true;
		if (frompriceWithoutSymbol >= 150) {
			while (flag) {

				if (frompriceWithoutSymbol == maxPrice) {
					break;
				} else {

					Actions action = new Actions(driver);
					action.click(filterSliderRightToLeft).build().perform();
					action.sendKeys(Keys.ARROW_LEFT).build().perform();

					int maxPriceAfterDrag = Integer.parseInt(filterMaxValue.getText().replace("₹", ""));

					if (maxPriceAfterDrag == maxPrice) {

						flag = false;

						break;
					} else {

						continue;
					}

				}
			}
		}

		extentReportLog("Moving slider from right to left");
		applyFilterButton.click();
		extentReportLog("Clicked on apply filter button");
		List<WebElement> list = withoutSaleBooks;
		List<WebElement> list1 = saleBooks;
		list.addAll(list1);
		List<String> priceList = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String priceWithoutSymbol = list.get(i).getText();
			priceWithoutSymbol = priceWithoutSymbol.replace("₹", "");
			priceList.add(priceWithoutSymbol);

		}

		for (int i = 0; i < priceList.size(); i++) {
			double price = Double.parseDouble(priceList.get(i));

			if (price >= 200 && price <= 450) {
				counter++;

			} else {
				notFound++;
			}

		}

		if (counter == priceList.size()) {
			extentReportLog("User is viewing books between 150 and 450");
		}

		else {
			extentReportLog("One of the book is not between 150 and 450");
		}

	}

	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}

}
