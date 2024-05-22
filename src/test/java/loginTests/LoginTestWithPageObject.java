package loginTests;

import baseTest.BaseTest;
import data.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTestWithPageObject extends BaseTest {
    //LoginTestWithPageObject#validLogin
    @Test
    public void TC_001_validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickOnLoginLink();
        pageProvider.getLoginPage().enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        pageProvider.getLoginPage().clickOnButtonSignIn();

//        Assert.assertTrue("Button Sign Out is not displayed", pageProvider.getHomePage().getHeaderElement().isButtonSignOutDisplayed());
//        Assert.assertFalse("Button Sign In is displayed", pageProvider.getHomePage().isButtonSignInDisplayed());
    }

    @Test
    public void TC_002_invalidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickOnLoginLink();
        pageProvider.getLoginPage().enterTextIntoInputLogin("NotValidLogin");
        pageProvider.getLoginPage().enterTextIntoInputPassword("123456qwerty");
        pageProvider.getLoginPage().clickOnButtonSignIn();

//        Assert.assertTrue("Button Sign In is not visible",
//                pageProvider.getHomePage().isButtonSignInDisplayed());
//        Assert.assertFalse("Button Sing Out is visible",
//                pageProvider.getHomePage().getHeaderElement().isButtonSignOutDisplayed());
//        Assert.assertTrue("Popup isn't displayed",
//                pageProvider.getHomePage().isPopUpDisplayed());
    }
}