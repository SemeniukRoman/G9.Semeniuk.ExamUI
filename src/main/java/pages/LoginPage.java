package pages;

public class LoginPage extends ParentPage {
//
//    @FindBy(xpath = "//button[contains(text(),'Sign In')]") //ініціалізується в CommonActionsWithElements
//    private WebElement buttonSignIn;
//
//    @FindBy(xpath = "//input[@placeholder='Username']")
//    private WebElement inputUserNameLoginForm;
//
//    @FindBy(xpath = "//input[@placeholder='Password']")
//    private WebElement inputPasswordLoginForm;
//
//    public LoginPage(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    public void openLoginPage() {
//        try{
//            webDriver.get("https://navi.gg/ua");
//            logger.info("Login Page was opened");
//        }catch (Exception e){
//            logger.error("Can not open Login Page" + e);
//            Assert.fail("Can not open Login Page" + e);
//        }
//    }
//
//    public void enterTextIntoInputLogin(String text) {
//        cleanAndEnterTextIntoElement(inputUserNameLoginForm, text);
//    }
//    public void enterTextIntoInputPassword(String text) {
//        cleanAndEnterTextIntoElement(inputPasswordLoginForm, text);
//    }
//
//    public void clickOnButtonSignIn(){
//        clickOnElement(buttonSignIn);
//    }
//
//    public HomePage openLoginPageAndFillLoginFormWithValidCred() {
//        openLoginPage();
//        enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
//        enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
//        clickOnButtonSignIn();
//        return new HomePage(webDriver);
//    }
}
