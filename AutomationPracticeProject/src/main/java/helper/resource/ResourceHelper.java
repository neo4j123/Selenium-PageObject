package helper.resource;

public class ResourceHelper {

	/**
	 * This metthod removed hard coded path
	 * @param path
	 * @return
	 */
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");		
		return basePath + "/" + path;
	}

}