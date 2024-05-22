package pages;

import data.TestData;
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

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public void openLoginPage() {
        try{
            webDriver.get("https://navi.gg/ua");
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    public void enterTextIntoInputLogin(String text) {
        cleanAndEnterTextIntoElement(inputUserNameLoginForm, text);
    }
    public void enterTextIntoInputPassword(String text) {
        cleanAndEnterTextIntoElement(inputPasswordLoginForm, text);
    }

    public void clickOnButtonSignIn(){
        clickOnElement(buttonSignIn);
    }

    public void clickOnLoginLink(){
        clickOnElement(LoginLink);
    }

    public HomePage openLoginPageAndFillLoginFormWithValidCred() {
        openLoginPage();
        enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
        enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        clickOnButtonSignIn();
        return new HomePage(webDriver);
    }
}
