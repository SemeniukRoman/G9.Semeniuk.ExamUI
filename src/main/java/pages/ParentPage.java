package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class ParentPage extends CommonActionsWithElements {

    String env = System.getProperty("env", "aqa");
    String baseUrl = String.format("https://navi.gg/ua", env);

    @FindBy(id = "CybotCookiebotDialogBodyButtonDecline")
    private WebElement cookiePopupDenyButton;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    abstract protected String getRelativeUrl();

    protected void checkUrl(){
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }


    @Step("Close cookie popup")
    public void closeCookiePopup(){
        if (isElementDisplayed(cookiePopupDenyButton)) {
            clickOnElement(cookiePopupDenyButton);
        }
    }
}
