package helper.generic;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class GenericMethods {

	/**
	 * This methods generates a new email everytime it is called
	 * 
	 * @return
	 */
	public static String getEmail() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString() + "@gmail.com";
		System.out.println(saltStr);
		return saltStr;
	}

	/**
	 * This method returns a new company name everytime it is called
	 * 
	 * @return
	 */
	public static String getCompanyString() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		System.out.println(saltStr);
		return saltStr;
	}

	/**
	 * This method will generate a new team name everytime it is called
	 * 
	 * @return
	 */
	public static String getTeamName() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		System.out.println(saltStr);
		return saltStr;
	}

	/**
	 * This method will verify the filled value in case of update profle scenario
	 * 
	 * @param ele
	 * @param value
	 * @return
	 */
	public static boolean verifyFilledValue(WebElement ele, String value) {
		String expectedValue = ele.getAttribute(value);
		if (expectedValue == value) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used for getting latest timestamp
	 * 
	 * @return
	 */
	public static String fn_GetTimeStamp() {
		DateFormat DF = DateFormat.getDateTimeInstance();
		Date dte = new Date();
		String DateValue = DF.format(dte);
		DateValue = DateValue.replaceAll(":", "_");
		DateValue = DateValue.replaceAll(",", "");
		return DateValue;
	}

}
