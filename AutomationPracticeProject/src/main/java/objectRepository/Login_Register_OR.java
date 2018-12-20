package objectRepository;

public class Login_Register_OR {
	
	public static final String MY_ACCOUNT = "//a[contains(text(),'My Account')]";
	public static final String EMAIL_ADDRESS = "//input[@id='reg_email']";
	public static final String PASSWORD = "//input[@id='reg_password']";
	public static final String REGISTER_BUTTON = "//input[@value='Register']";
	public static final String ERROR_MESSAGE = "//ul[@class='woocommerce-error']//li";
	public static final String NO_PASSWORD_TEXT = "Error: Please enter an account password.";
	public static final String NO_EMAIL_PASSWORD = "Error: Please provide a valid email address.";
	public static final String EXISTING_EMAIL_PASSWORD = "Error: An account is already registered with your email address. Please login.";
	public static final String SUCESSFULL_REGISTER_MESSAGE = "//div[contains(@class,'woocommerce-MyAccount-content')]//p[2]";
	public static final String SUCESSFULL_REGISTER_MESSAGE_TEXT = "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";
	

	//Login Page Elements
	public static final String LOGIN_EMAIL = "//input[@id='username']";
	public static final String LOGIN_PASSWORD = "//input[@id='password']";
	public static final String LOGIN_BUTTON = "//input[@value='Login']";
	public static final String LOGIN_ERROR_MESSAGE_INVALID_CREDENTIALS = "ERROR: Invalid username. Lost your password?";
	public static final String LOGIN_ERROR_TEXT_CORRECT_EMAIL_BLANK_PASSWORD = "ERROR: The password you entered for the username akash.srivastava is incorrect. Lost your password?";
	public static final String LOGIN_ERROR_TEXT_BLANK_USERNAME_VALID_PASSWORD = "Error: Username is required.";
	public static final String LOGIN_BLANK_PASSWORD_TEXT = "Error: Password is required.";
	
	
	
	
	
	
	
	
}
