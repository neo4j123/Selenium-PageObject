package objectRepository;

public class OrderPage_OR {

	public static final String Order_Number = "//a[contains(text(),'#778')]";
	public static final String order_View_Button = "//a[@class='button view']";

	public static final String Customer_Email = "//table[@class='shop_table customer_details']/tbody/tr[1]/td";
	public static final String Customer_Phone = "//table[@class='shop_table customer_details']/tbody/tr[2]/td";

	public static final String Billing_Details = "//div[@class='woocommerce-MyAccount-content']//address";
	public static final String PAYMENT_METHOD = "//table[@class='shop_table order_details']/tfoot/tr[3]/td";
	
	public static final String orderNumber = "//mark[@class='order-number']";
	public static final String orderStatus = "//mark[@class='order-status']";
	public static final String orderDate = "//mark[@class='order-date']";
	
}
