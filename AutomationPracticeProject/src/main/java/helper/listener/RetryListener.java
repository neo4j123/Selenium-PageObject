package helper.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import helper.logger.LoggerHelper;

public class RetryListener implements IAnnotationTransformer {

	private Logger log = LoggerHelper.getLogger(RetryListener.class);

	public void transform(ITestAnnotation arg0, @SuppressWarnings("rawtypes") Class arg1,
			@SuppressWarnings("rawtypes") Constructor arg2, Method arg3) {
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();
		if (retry == null) {
			log.info("Listening to failed test case");
			arg0.setRetryAnalyzer(RetryHelper.class);
		}
	}

}
