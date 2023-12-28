package CucumberGermanPractice.carina.demo.cucumber.steps;

import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
import CucumberGermanPractice.carina.demo.gui.desktop.HomePage;
import CucumberGermanPractice.carina.demo.gui.desktop.Service;
import CucumberGermanPractice.carina.demo.gui.models.UserMapper;
import CucumberGermanPractice.carina.demo.gui.models.WebUsers;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.*;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;

import java.util.List;

public class AddProductFromDB extends CucumberRunner {
    HomePage homePage = new HomePage(getDriver());
    Service service = new Service(getDriver());

    @Given("user is on login page")
    public void i_am_on_main_page() {
        homePage.open();
    }

    @When("user enters username and password")
    public void i_log_in() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            WebUsers user = userMapper.findById(1);
            String username = user.getUsername();
            String pass = user.getPassword();
            homePage.setUserName(username);
            homePage.setUserPassWord(pass);
        }
    }

    @And("if DB product is present it is added to chart")
    public void getDataFromDB() {
        List<String> dbProducts = service.gettingProductFromDB();
        System.out.println("Here are the DB products");
        for (String p : dbProducts) {
            System.out.println(p);
        }
        List<String> webProducts = service.parsingWebElementToString();
        System.out.println("Here are the WebElement products");
        for (String e : webProducts) {
            System.out.println(e);
        }

    }

    @Then("Product title must be present in chart orders")
    public void products_should_be_added_to_chart() {
        ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
        Assert.assertEquals(productsPage.getProductTitle(), "Products");
    }
}
