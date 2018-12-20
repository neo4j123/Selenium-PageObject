package helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import helper.logger.LoggerHelper;

public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	/**
	 * This method will be used to match actual text vs expected text
	 * 
	 * @param actual
	 * @param expected
	 */
	public static void verifyText(String actual, String expected) {
		log.info("Verifing text");
		Assert.assertEquals(actual, expected);
	}
	
	/**
	 * This method will be used to match actual count vs expected count
	 * 
	 * @param actual
	 * @param expected
	 */
	public static void verifyCount(int actual, int expected) {
		log.info("Verifing count");
		Assert.assertEquals(actual, expected);
	}

	/**
	 * This method will verify the true
	 */
	public static void makeTrue() {
		log.info("Making Script Pass Intentionally");
		Assert.assertTrue(true);
	}

	/**
	 * This method will verify the true with a message
	 * 
	 * @param message
	 */
	public static void makeTrue(String message) {
		log.info("Making Script Pass Intentionally with a message");
		Assert.assertTrue(true, message);
	}

	/**
	 * This method will verify the false
	 */
	public static void makeFalse() {
		log.info("Making Script fail Intentionally");
		Assert.assertTrue(false);
	}

	/**
	 * This method will verify the false with a message
	 * 
	 * @param message
	 */
	public static void makeFalse(String message) {
		log.info("Making Script Pass Intentionally with a message");
		Assert.assertTrue(false, message);
	}

	/**
	 * This method will help in verifying true boolean status
	 * 
	 * @param status
	 */
	public static void verrifyTrue(boolean status) {
		Assert.assertTrue(status);
	}

	/**
	 * This method will help in verifying false boolean status
	 * 
	 * @param status
	 */
	public static void verrifyFalse(boolean status) {
		Assert.assertFalse(status);
	}

	/**
	 * This method will verify null texts
	 * 
	 * @param text
	 */
	public static void verifyNull(String text) {
		log.info("Verify object is NULL");
		Assert.assertNull(text);
	}

	/**
	 * This method will verify not null texts
	 * 
	 * @param text
	 */
	public static void verifyNotNull(String text) {
		log.info("Verify object is not NULL");
		Assert.assertNotNull(text);
	}

	public static void updateTestStatus(boolean status) {
		if (status) {
			pass();
		} else {
			fail();
		}
	}

	public static void fail() {
		Assert.assertTrue(false);
	}

	public static void pass() {
		Assert.assertTrue(true);
	}
}
