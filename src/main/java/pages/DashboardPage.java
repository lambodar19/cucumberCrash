package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;
    public  DashboardPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By dahboardIcon = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']" +
                                                    "//h6[text()='Dashboard']");

public void verifyDashboardIcon()
{
    boolean flag = driver.findElement(dahboardIcon).isDisplayed();
    Assert.assertEquals("true",flag,"Expected condition matched");

}

}
