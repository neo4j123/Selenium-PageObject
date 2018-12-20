package helper.browserConfig;

import helper.browserConfiguration.BrowserType;

public interface ConfigReader {

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPageLoadTimeOut();

	public BrowserType getBrowserType();

	public String getUrl();
	
	public String getUserReviews();
	
	public String getName();
	
	public String getEmail();

}
