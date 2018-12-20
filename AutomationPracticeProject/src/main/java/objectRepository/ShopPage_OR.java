package objectRepository;

public class ShopPage_OR {

	public static final String HOME_LINK = "//a[contains(text(),'Home')]";
	public static final String SHOP_LINK = "//a[contains(text(),'Shop')]";
	public static final String minPriceProduct = "//span[contains(@class,'from')]";
	public static final String sliderLeftToRight = "//div[contains(@class,'price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all')]//span[1]";
	public static final String fromPrice = "//span[contains(@class,'from')]";
	public static final String maxPriceProduct = "//span[contains(@class,'to')]";
	public static final String sliderRightToLeft = "//div[contains(@class,'price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all')]//span[2]";
	public static final String filterButtonProduct = "//button[contains(@type,'submit')]";
	public static final String SalePriceBooks = "//ins/span[@class='woocommerce-Price-amount amount']";
	public static final String WithoutSaleBooks = " //span[@class='price']/span[@class='woocommerce-Price-amount amount']";

	// Next Filter Elements
	public static final String PRODUCT_CATEGORY_FILTER_COUNT = "//li[@class='cat-item cat-item-24']//span[@class='count'][contains(text(),'(1)')]";
	public static final String PRODUCT_LIST = "//ul[@class='products masonry-done']";
	public static final String ORDER_BY = "//select[@name='orderby']";

	public static final String OUT_OF_STOCK_PRODUCT = "//img[@title='Thinking in HTML']";
	public static final String OUT_OF_STOCK_MESSAGE = "//p[@class='stock out-of-stock']";
	public static final String OUT_OF_STOCK_TEXT = "Out of stock";

	public static final String SALE_PRODUCT = "//li[@class='post-169 product type-product status-publish product_cat-android product_tag-android has-post-title no-post-date has-post-category has-post-tag has-post-comment has-post-author first instock sale downloadable taxable shipping-taxable purchasable product-type-simple']//span[@class='onsale'][contains(text(),'Sale!')]";
	public static final String SALE_PRICE = "//del//span[@class='woocommerce-Price-amount amount']";
	public static final String ACTUAL_PRICE = "//ins//span[@class='woocommerce-Price-amount amount']";
	
	
	
}
