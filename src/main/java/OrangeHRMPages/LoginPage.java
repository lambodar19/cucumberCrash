package OrangeHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By usernameL = By.name("username");
    private By passwordL = By.name("password");
    private By loginBtnL = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username)
    {
        WebElement usernameField =driver.findElement(usernameL);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        WebElement passwordField =driver.findElement(passwordL);
        passwordField.sendKeys(password);
    }

    public void clickLogin()
    {
        WebElement loginButton =driver.findElement(loginBtnL);
        loginButton.click();
    }
}
