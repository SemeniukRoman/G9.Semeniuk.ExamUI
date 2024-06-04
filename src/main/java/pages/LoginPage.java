package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//a[@class='login__link']")
    private WebElement loginLink;

    @FindBy(xpath = "//button[@type='submit']") //ініціалізується в CommonActionsWithElements
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement inputUserNameLoginForm;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPasswordLoginForm;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
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
        clickOnElement(loginLink);
    }

    @Step("Log in")
    public void login(String login, String pass) {
        clickOnElement(loginLink);
        enterTextIntoInputLogin(login);
        enterTextIntoInputPassword(pass);
        clickOnButtonSignIn();
    }
}
