//package CucumberGermanPractice.carina.demo.cucumber.steps;
//
//import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
//import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
//import CucumberGermanPractice.carina.demo.gui.desktop.HomePage;
//import CucumberGermanPractice.carina.demo.gui.models.UserMapper;
//import CucumberGermanPractice.carina.demo.gui.models.WebUsers;
//import com.zebrunner.carina.cucumber.CucumberRunner;
//import io.cucumber.java.en.*;
//import org.apache.ibatis.session.SqlSession;
//import org.testng.Assert;
//
//public class OpenSauceDemoWeb extends CucumberRunner {
//    HomePage homePage = new HomePage(getDriver());
//
//    @Given("user is on login page")
//    public void i_am_on_main_page() {
//        homePage.open();
//    }
//
//
//    @When("user enters username and password")
//    public void i_log_in() {
//        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            WebUsers user = userMapper.findById(1);
//            String username = user.getUsername();
//            String pass = user.getPassword();
//            homePage.setUserName(username);
//            homePage.setUserPassWord(pass);
//        }
//    }
//
//    @Then("Product title must be present")
//    public void products_page_should_be_opened() {
//        ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
//        Assert.assertEquals(productsPage.getProductTitle(), "Products");
//    }
//}
