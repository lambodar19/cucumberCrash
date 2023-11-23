package appHooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.ExtentReportManager;

import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    private ExtentTest extentTest;

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        extentTest = ExtentReportManager.getInstance().createTest(scenario.getName());
    }
    @Before(order = 1)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 2)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(DriverFactory.BrowserType.valueOf(browserName));

    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

/*    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // take screenshot:
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Attach the screenshot to the Cucumber report:
                scenario.attach(sourcePath, "image/png", screenshotName);

                // Log success message:
                System.out.println("Screenshot captured and attached for scenario: " + scenario.getName());
            } catch (Exception e) {
                // Log error if screenshot capture fails:
                System.err.println("Failed to capture and attach screenshot for scenario: " + scenario.getName());
                e.printStackTrace();
            }
        }
    }*/

    @After(order=1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Attach the screenshot to the Cucumber report:
            scenario.attach(sourcePath, "image/png", screenshotName);
            extentTest.log(Status.FAIL, "Test Case Failed: " + scenario.getName());
            extentTest.addScreenCaptureFromPath("screenshotName.png");
            // Add more details, screenshots, etc. as needed
        } else {
            extentTest.log(Status.PASS, "Test Case Passed: " + scenario.getName());
        }

        ExtentReportManager.getInstance().flush();
    }
}