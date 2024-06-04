package loginTests;

import baseTest.BaseTest;
import data.TestData;
import org.junit.After;
import org.junit.Test;

public class UpdateSettingsTest extends BaseTest {

    final String oldName = "Test";
    final String newName = "Auto";

    @Test
    public void TC_003_updateSettings() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getLoginPage().closeCookiePopup();
        pageProvider.getLoginPage().login(TestData.VALID_LOGIN_UI, TestData.VALID_PASSWORD_UI);

        pageProvider.getHomePage().clickOnSettingsItem();
        pageProvider.getSettingsPage().assertPageIsOpened();

        pageProvider.getSettingsPage().checkNameInputValue(oldName);
        pageProvider.getSettingsPage().setNameInputValue(newName);
        pageProvider.getSettingsPage().checkNameInputValue(newName);

    }

    @After
    public void tearDown() {
        pageProvider.getSettingsPage().setNameInputValue(oldName);
        pageProvider.getSettingsPage().checkNameInputValue(oldName);
        logger.info("Set default value to 'Name' input");
    }

}