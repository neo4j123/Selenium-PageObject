package objectRepository;

public class AddressPage_OR {
	
	public static final String BILLING_ADDRESS = "//div[@class='u-column1 col-1 woocommerce-Address']//address";
	public static final String SHIPPING_ADDRESS = "//div[@class='u-column2 col-2 woocommerce-Address']//address";
	
	public static final String EDIT_BILLING_ADDRESS = "//div[@class='u-column1 col-1 woocommerce-Address']//a[@class='edit'][contains(text(),'Edit')]";
	public static final String EDIT_SHIPPING_ADDRESS = "//div[@class='u-column2 col-2 woocommerce-Address']//a[@class='edit'][contains(text(),'Edit')]";
	
	
	
}
