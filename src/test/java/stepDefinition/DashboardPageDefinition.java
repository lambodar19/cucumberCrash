package stepDefinition;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class DashboardPageDefinition {

 private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
 private DashboardPage dashboardPage;

    @Given("user is already logged in")
    public void user_is_already_logged_in(DataTable dataTable) {
    List<Map<String, String>> creds= dataTable.asMaps();
    String username= creds.get(0).get("username");
    String password= creds.get(0).get("password");

        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        dashboardPage = loginPage.login(username,password);
    }
    @When("user sees the dashboard icon")
    public void user_sees_the_dashboard_icon() throws InterruptedException {

        Thread.sleep(20000);
       dashboardPage.verifyDashboardIcon();
    }
    @Then("user is on dashboard screen")
    public void user_is_on_dashboard_screen() {

        System.out.println("User is on dashboard screen");
    }



}
