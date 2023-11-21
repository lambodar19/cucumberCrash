package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submidt']");



    public void enterCredentials(String uName, String pwd) {
        driver.findElement(userName).sendKeys(uName);
        driver.findElement(password).sendKeys(pwd);

    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();


    }
}
