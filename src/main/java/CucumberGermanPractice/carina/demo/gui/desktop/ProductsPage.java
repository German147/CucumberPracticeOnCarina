package CucumberGermanPractice.carina.demo.gui.desktop;

import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(css = ".title")
    private ExtendedWebElement productText;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitle() {
        return productText.getText();
    }


}
