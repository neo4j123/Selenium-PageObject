package objectRepository;

public class OrderConfirmationPage_OR {

	public static final String ORDER_PLACED_TEXT = "Thank you. Your order has been received.";
	public static final String ORDER_PLACED_MESSAGE = "//p[@class='woocommerce-thankyou-order-received']";
	
	public static final String PAYMENT_METHOD = "//td[contains(text(),'Direct Bank Transfer')]";
	public static final String PAYMENT_METHOD_TEXT = "Direct Bank Transfer";
	public static final String BANK_TRANSFER_TEXT = "Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.";
	public static final String BANK_TRANSFER_MESSAGE = "//p[contains(text(),'Make your payment directly into our bank account. ')]";

}
