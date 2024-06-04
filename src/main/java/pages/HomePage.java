package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {

    @FindBy(xpath = "//a[contains(@href, 'settings')]")
    private WebElement settingsItem;

    @FindBy(xpath = "//div[@class='login__link']")
    private WebElement userIcon;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return new HeaderElement(webDriver);
    }

    public void openHomePage() {
        try {
            webDriver.get("https://navi.gg/ua");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    @Step("Click on 'Settings' login popup item")
    public void clickOnSettingsItem() {
        clickOnElement(userIcon);
        clickOnElement(settingsItem);
    }
}
