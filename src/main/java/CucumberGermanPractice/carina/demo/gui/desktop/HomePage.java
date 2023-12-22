package CucumberGermanPractice.carina.demo.gui.desktop;

import CucumberGermanPractice.carina.demo.gui.commons.HomePageBase;
import CucumberGermanPractice.carina.demo.gui.commons.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {

    @FindBy(css = "#user-name")
    private ExtendedWebElement userName;
    @FindBy(css = "#password")
    private ExtendedWebElement password;

    @FindBy(css = "#login-button")
    private ExtendedWebElement loginBtn;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setUserName(String username) {
        userName.type(username);
    }

    @Override
    public void setUserPassWord(String passWord) {
        password.type(passWord);
    }

    @Override
    public ProductsPageBase clickLoginButton() {
        loginBtn.click();
        return initPage(getDriver(), ProductsPageBase.class);
    }


}
