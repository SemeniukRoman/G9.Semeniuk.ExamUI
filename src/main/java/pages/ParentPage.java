package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class ParentPage extends CommonActionsWithElements {

    @FindBy(id = "CybotCookiebotDialogBodyButtonDecline")
    private WebElement cookiePopupDenyButton;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Step("Close cookie popup")
    public void closeCookiePopup(){
        if (isElementDisplayed(cookiePopupDenyButton)) {
            clickOnElement(cookiePopupDenyButton);
        }
    }
}
