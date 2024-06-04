package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckSearchTest extends BaseTest {

    @Test
    public void TC_004_changeLanguageTest() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getLoginPage().closeCookiePopup();

        pageProvider.getHomePage().getHeaderElement().clickSearchIcon();
        pageProvider.getHomePage().getHeaderElement().enterSearchValue("b1t");
        pageProvider.getHomePage().getHeaderElement().checkSearchResultsListIsVisible();
    }
}