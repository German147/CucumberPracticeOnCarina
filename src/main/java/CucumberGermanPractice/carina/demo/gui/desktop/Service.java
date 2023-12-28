package CucumberGermanPractice.carina.demo.gui.desktop;

import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
import CucumberGermanPractice.carina.demo.gui.commons.ServiceBase;
import CucumberGermanPractice.carina.demo.gui.models.UserOrders;
import CucumberGermanPractice.carina.demo.gui.models.UserOrdersMapper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Service extends ServiceBase {

    @FindBy(css = ".inventory_item_name ")
    private ExtendedWebElement productsName;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement addBackPack;

    public Service(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> gettingProductsName() {
        List<WebElement> elements = getDriver().findElements(productsName.getBy());
        return elements;
    }

    @Override
    public List<String> gettingProductFromDB() {
        List<String> dbProducts = new ArrayList<>();
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserOrdersMapper orderMapper = session.getMapper(UserOrdersMapper.class);
            List<UserOrders> userOrdersList2 = orderMapper.findOrdersByUserId(1);
            for (UserOrders order : userOrdersList2) {
                dbProducts.add(order.getProduct());
            }
        }
        return dbProducts;
    }

    @Override
    public List<String> parsingWebElementToString() {
        List<String> webElementStrings = new ArrayList<>();
        List<WebElement> element = gettingProductsName();
        for (WebElement e : element) {
            webElementStrings.add(e.getText());
        }
        return webElementStrings;
    }

    @Override
    public void addProductToChart() {
        List<String> webElements = parsingWebElementToString();
        List<String> dbProducts =  gettingProductFromDB();
        
    }


}
