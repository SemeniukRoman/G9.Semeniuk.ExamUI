package pages.elements;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class SettingsPage extends ParentPage {

    @FindBy(xpath = "//span[text() = 'Settings']")
    private WebElement settingsItem;

    @FindBy(css = ".form-text-field--disabled + label input")
    private WebElement nameLastNameInput;

    @FindBy(xpath = "//div[@class='user-settings__btn']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='cabinet-modal']")
    private WebElement successModal;

    @FindBy(xpath = "//div[@class='cabinet-modal__btn']")
    private WebElement successModalOkButton;

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public SettingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert 'Settings' page is opened")
    public void assertPageIsOpened() {
        checkElementIsDisplayed(nameLastNameInput);
    }


    @Step("Check 'Name, last name' input value is '{0}'")
    public void checkNameInputValue(String inputValue) {
        Assert.assertEquals(nameLastNameInput.getAttribute("value"), inputValue);
    }

    @Step("Set '{0}' value to 'Name, last name' input")
    public void setNameInputValue(String inputValue) {
        nameLastNameInput.clear();
        nameLastNameInput.sendKeys(inputValue);
        clickOnElement(saveButton);
        assertSuccessModalIsDisplayed();
        closeSuccessModalIsDisplayed();
    }

    @Step("Assert success modal is displayed")
    public void assertSuccessModalIsDisplayed() {
        checkElementIsDisplayed(successModal);
    }

    @Step("Close success modal is displayed")
    public void closeSuccessModalIsDisplayed() {
        clickOnElement(successModalOkButton);
        checkElementIsNotDisplayed(successModal);
    }
}
