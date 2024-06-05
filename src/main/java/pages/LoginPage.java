package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//a[@class='login__link']")
    private WebElement LoginLink;

    @FindBy(xpath = "//button[@type='submit']") //ініціалізується в CommonActionsWithElements
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement inputUserNameLoginForm;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPasswordLoginForm;

    @FindBy(xpath = "//div[@class='Field__Error']")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public void enterTextIntoInputLogin(String text) {
        cleanAndEnterTextIntoElement(inputUserNameLoginForm, text);
    }

    public void enterTextIntoInputPassword(String text) {
        cleanAndEnterTextIntoElement(inputPasswordLoginForm, text);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void clickOnLoginLink() {
        clickOnElement(LoginLink);
    }

    @Step("Log in")
    public void login(String login, String pass) {
        clickOnElement(LoginLink);
        enterTextIntoInputLogin(login);
        enterTextIntoInputPassword(pass);
        clickOnButtonSignIn();
    }

    @Step("Assert login error message is displayed")
    public void assertLoginErrorMessage(String expectedErrorMessage) {
        checkElementIsDisplayed(loginErrorMessage);
        Assert.assertEquals(expectedErrorMessage, loginErrorMessage.getText());
    }
}
