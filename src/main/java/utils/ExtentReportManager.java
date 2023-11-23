package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            createInstance("extent-report.html");
        }
        return extentReports;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }
}
