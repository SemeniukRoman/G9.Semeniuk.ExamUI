package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ChangeLanguageTest extends BaseTest {

    @Test
    public void TC_004_changeLanguageTest() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getLoginPage().closeCookiePopup();

        pageProvider.getHomePage().getHeaderElement().checkTeamsTitleLanguage("КОМАНДА");
        pageProvider.getHomePage().getHeaderElement().changeLanguageToEnglish();
        pageProvider.getHomePage().getHeaderElement().checkTeamsTitleLanguage("TEAM");
    }
}