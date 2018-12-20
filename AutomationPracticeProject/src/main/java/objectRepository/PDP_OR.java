package objectRepository;

public class PDP_OR {

	public static final String PRODUCT_TITLE = "//h1[@class='product_title entry-title']";
	
	public static final String ADD_TO_BASKET = "//button[@type='submit']";
	public static final String EXPECTED_ADD_TO_BASKET_BUTTON_TEXT = "ADD TO BASKET";
	public static final String DESCRIPTION_TAB = "//a[contains(text(),'Description')]";
	public static final String DESCRIPTION_BOX = "//div[@id='tab-description']//p[contains(text(),'The Selenium WebDriver Recipes book is a quick pro')]";
	public static final String DESCRIPTION_TEXT = "The Selenium WebDriver Recipes book is a quick problem-solving guide to "
			+ "automated testing web applications with Selenium WebDriver. It contains hundreds of solutions to real-world "
			+ "problems, with clear explanations and ready-to-run test scripts you can use in your own projects.";
	public static final String REVIEW_TAB = ".//*[@id='product-160']/div[3]/ul/li[2]/a";
	public static final String REVIEW_HEADING = ".//*[@id='comments']/h2";	
	public static final String USER_REVIEW_SECTION = "//textarea[@id='comment']";
	public static final String NAME_COMMENTS = "//input[@id='author']";
	public static final String EMAIL_COMMENTS = "//input[@id='email']";
	public static final String SUBMIT_BUTTON_COMMENTS = "//input[@id='submit']";
	public static final String COMMENTS_BOX = "//ol[@class='commentlist']";
	public static final String ADD_TO_BASKET_MESSAGE = "//div[@class='woocommerce-message']";
	public static final String MENU_ITEM_PRICE = "//span[@class='amount']";
	
	
	
	
}
