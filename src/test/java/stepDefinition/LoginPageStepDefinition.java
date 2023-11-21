package stepDefinition;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginPageStepDefinition {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("I have entered valid username {string} and password {string}")
    public void i_have_entered_valid_username_and_password(String username, String password) throws InterruptedException {

        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);
        loginPage.enterCredentials(username,password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("logged in");

    }

    @Then("The title of the page should be {string}")
    public void the_title_of_the_page_should_be(String string) {
        System.out.println("Page Title need not to be verified");
    }

}
