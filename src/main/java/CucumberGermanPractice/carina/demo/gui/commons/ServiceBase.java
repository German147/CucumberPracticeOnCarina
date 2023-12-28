package CucumberGermanPractice.carina.demo.gui.commons;


import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ServiceBase extends AbstractPage {

    public ServiceBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<WebElement> gettingProductsName();

    public abstract List<String> gettingProductFromDB();

    public abstract List<String> parsingWebElementToString();

    public abstract void addProductToChart();
}
