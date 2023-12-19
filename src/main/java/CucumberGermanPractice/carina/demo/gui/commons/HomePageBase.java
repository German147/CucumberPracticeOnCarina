package CucumberGermanPractice.carina.demo.gui.commons;

import CucumberGermanPractice.carina.demo.gui.desktop.ProductsPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void setUserName(String username);
    public abstract void setUserPassWord(String passWord);
    public abstract ProductsPageBase clickLoginButton();

//    public abstract SignInPageBase clickOnSignIn();
//
//    public abstract void clickOnBurgerButton();
//
//    public abstract boolean isGreetingMessagePresent();
//    public abstract boolean isHomePageOpened();
//
//    public abstract HomePageBase hoverOverChangeLanguage();
//
//    public abstract HomePageBase clickIfOldPageIsPresent();
//
//    public abstract List<WebElement> burgerButtonList();
//
//    public abstract YourAccountPageBase clickOnYourAccount();
//
//    public abstract HomePageBase clickOnSearchBar();
//
//    public abstract HomePageBase typeProduct(String xiaomi);
//
//    public abstract ProductsPageBase clickOnSearchIcon();



}
