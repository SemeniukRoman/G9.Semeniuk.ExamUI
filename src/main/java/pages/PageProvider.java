package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.SettingsPage;

public class PageProvider {
    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage(){
        return new HomePage(webDriver);
    }

    public SettingsPage getSettingsPage(){
        return new SettingsPage(webDriver);
    }
}
