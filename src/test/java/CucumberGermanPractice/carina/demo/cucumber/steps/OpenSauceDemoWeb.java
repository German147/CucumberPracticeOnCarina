package CucumberGermanPractice.carina.demo.cucumber.steps;

import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
import CucumberGermanPractice.carina.demo.gui.commons.HomePageBase;
import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
import CucumberGermanPractice.carina.demo.gui.desktop.HomePage;
import CucumberGermanPractice.carina.demo.gui.desktop.ProductsPage;
import CucumberGermanPractice.carina.demo.gui.models.UserMapper;
import CucumberGermanPractice.carina.demo.gui.models.UserOrders;
import CucumberGermanPractice.carina.demo.gui.models.UserOrdersMapper;
import CucumberGermanPractice.carina.demo.gui.models.WebUsers;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.*;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;

public class OpenSauceDemoWeb extends CucumberRunner {
    HomePage homePage = new HomePage(getDriver());
    ProductsPageBase productsPage = null;

    @Given("I am on main page")
    public void i_am_on_main_page() {
        homePage.open();
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            WebUsers user = userMapper.findById(1);
            String username = user.getUsername();
            String pass = user.getPassword();
            homePage.setUserName(username);
            homePage.setUserPassWord(pass);

//            UserOrdersMapper ordersMapper = session.getMapper(UserOrdersMapper.class);
//            UserOrders orders = ordersMapper.findById(1);
//            System.out.println(orders.getProduct());
//            System.out.println("Some letters....");


//            UserOrders orders = user.getorders();
//             String productName =  orders.getProduct();
//             Assert.assertEquals(productName,"expectedListName");

        }
    }

    @When("I log in.")
    public void i_log_in() {
        productsPage = homePage.clickLoginButton();
    }

    @Then("Products page should be opened")
    public void products_page_should_be_opened() {
        Assert.assertEquals(productsPage.getProductTitle(), "Products");
    }
}
