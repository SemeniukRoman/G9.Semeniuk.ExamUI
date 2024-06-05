package pages;

import data.TestData;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[contains(text(), 'Invalid username/password.')]")
    private WebElement popUp;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public HeaderElement getHeaderElement() {
        return new HeaderElement(webDriver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        Assert.assertTrue("Invalid page is not Home page", getHeaderElement().isButtonSignOutDisplayed());
        return this;
    }

    @Step
    public boolean isButtonSignInDisplayed(){
        return isElementDisplayed(buttonSignIn);
    }
    public boolean isPopUpDisplayed(){
        return isElementDisplayed(popUp);
    }

    @Step
    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        openHomePage();
        if (this.getHeaderElement().isButtonSignOutDisplayed()){
            logger.info("User is already logged in");
        } else {
            loginPage.enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
            loginPage.enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
            loginPage.clickOnButtonSignIn();
            checkIsRedirectToHomePage();
            logger.info("User was logged in");
        }
        return this;
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

    @Step("Assert user is logged in")
    public void assertUserIsLoggedIn() {
        getHeaderElement().assertUserNickNameIsDisplayed();
    }

}
