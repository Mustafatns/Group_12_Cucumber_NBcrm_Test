package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.LoginToNBcrmW_excel;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class loginPage_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    LoginToNBcrmW_excel loginToNBcrmW_excel = new LoginToNBcrmW_excel();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        System.out.println("user is on login page");
    }

    @When("user enter username, password and click to login button")
    public void userEnterUsernamePasswordAndClickToLoginButton() throws IOException {

    }

    @Then("user see the Dashboard page")
    public void user_see_the_dashboard_page() {
        WebElement activitySteam = Driver.getDriver().findElement(By.xpath("//div[@id='pagetitle']"));
        String expectedResult = "Activity Stream";

        Assert.assertTrue(activitySteam.getText().equals(expectedResult));
    }



}
