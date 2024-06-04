package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckSearchTest extends BaseTest {

    @Test
    public void TC_005_checkSearchTest() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getLoginPage().closeCookiePopup();

        pageProvider.getHomePage().getHeaderElement().clickSearchIcon();
        pageProvider.getHomePage().getHeaderElement().enterSearchValue("b1t");
        pageProvider.getHomePage().getHeaderElement().checkSearchResultsListIsVisible();
    }
}