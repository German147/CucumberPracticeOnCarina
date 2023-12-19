package CucumberGermanPractice.carina.demo.cucumber.steps;

import CucumberGermanPractice.carina.demo.gui.commons.HomePageBase;
import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
import CucumberGermanPractice.carina.demo.gui.desktop.HomePage;
import CucumberGermanPractice.carina.demo.gui.desktop.ProductsPage;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class OpenSauceDemoWeb extends CucumberRunner {
    HomePage homePage = new HomePage(getDriver());
    ProductsPageBase productsPage = null;

    @Given("I am on main page")
    public void i_am_on_main_page() {
        homePage.open();
        homePage.setUserName("standard_user");
        homePage.setUserPassWord("secret_sauce");

    }

    @When("I log in.")
    public void i_log_in() {
        productsPage = homePage.clickLoginButton();
    }

    @Then("Products page should be opened")
    public void products_page_should_be_opened() {
        Assert.assertEquals(productsPage.getProductTitle(),"Products");
    }
}
