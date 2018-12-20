package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentHelper {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			return createInstance("test-output//extent.html");
		} else {
			return extent;
		}
	}

	/**
	 * This method is used for designing extent reporting format
	 * 
	 * @param fileName
	 * @return
	 */
	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Reports");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
