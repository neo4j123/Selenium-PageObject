package objectRepository;

public class BASKET_OR {
	
	public static final String VIEW_BASKET = "//a[@class='button wc-forward']";
	public static final String ITEM_PRICE = "//td[@class='product-price']//span[@class='woocommerce-Price-amount amount']";
	public static final String COUPON_CODE_TEXT_BOX = "//input[@id='coupon_code']";
	public static final String COUPON_SUBMIT_BUTTON = "//input[@value='Apply Coupon']";
	public static final String COUPON_VALIDATE_TEXT = "//th[contains(text(),'Coupon: krishnasakinala')]";
	public static final String COUPON_TEXT = "Coupon: krishnasakinala";
	public static final String COUPON_ERROR = "//ul[@class='woocommerce-error']//li";
	public static final String COUPON_ERROR_TEXT = "The minimum spend for this coupon is 450.00.";
	public static final String REMOVE_ITEM = "//a[@title='Remove this item']";
	public static final String REMOVE_ITEM_MESSAGE = "//div[@class='woocommerce-message']";
	public static final String QUANTITY_ITEM = "//input[@title='Qty']";
	public static final String UPDATE_BASKET_BUTTON = "//input[@value='Update Basket']";
	public static final String BASKET_UPDATE_MESSAGE = "Basket updated.";
	public static final String TOTAL_AMOUNT = "//tr[contains(@class,'order-total')]//td[contains(@data-title,'Total')]/strong/span";
	public static final String TOTAL_AMOUNT_TEXT = "₹357.00";
	public static final String SUBTOTAL_AMOUNT = "//td[contains(@data-title,'Subtotal')]//span[contains(@class,'woocommerce-Price-amount amount')]";
	public static final String SUBTOTAL_AMOUNT_TEXT = "₹350.00";
	public static final String PROCEED_CHECKOUT_BUTTON = "//a[contains(@class,'checkout-button button alt wc-forward')]";
	
	
	

}
