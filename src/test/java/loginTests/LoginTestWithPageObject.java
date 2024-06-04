package loginTests;

import baseTest.BaseTest;
import data.TestData;
import org.junit.Test;

public class LoginTestWithPageObject extends BaseTest {

    @Test
    public void TC_001_validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickOnLoginLink();
        pageProvider.getLoginPage().enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @Test
    public void TC_002_invalidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickOnLoginLink();
        pageProvider.getLoginPage().enterTextIntoInputLogin("NotValidLogin");
        pageProvider.getLoginPage().enterTextIntoInputPassword("123456qwerty");
        pageProvider.getLoginPage().clickOnButtonSignIn();

    }
}