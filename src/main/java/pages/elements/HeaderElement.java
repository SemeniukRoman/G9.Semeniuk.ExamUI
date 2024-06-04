package pages.elements;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy(xpath = "//*[@class='text-white mr-2']")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='text-white mr-2 header-chat-icon']")
    private WebElement chatIcon;

    @FindBy(xpath = "//button[@class='switch-language__btn']")
    private WebElement switchLanguageButton;

    @FindBy(xpath = "//li/a[@href='https://navi.gg/en']")
    private WebElement englishLanguageSwitcherOption;

    @FindBy(xpath = "//nav/a[contains(@href, '/teams')]")
    private WebElement teamsHeaderMenuOption;

    @FindBy(xpath = "//*[@class='icon-search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@class='search-block__input']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='search-section__body']")
    private WebElement searchResultsList;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Change language to 'en'")
    public void changeLanguageToEnglish() {
        checkElementIsDisplayed(switchLanguageButton);
        clickOnElement(switchLanguageButton);
        checkElementIsDisplayed(englishLanguageSwitcherOption);
        clickOnElement(englishLanguageSwitcherOption);
    }

    @Step("Check title is '{0}'")
    public void checkTeamsTitleLanguage(String title) {
        checkElementIsDisplayed(teamsHeaderMenuOption);
        Assert.assertEquals(teamsHeaderMenuOption.getText(), title);
    }

    @Step("Click search icon and check search input is displayed")
    public void clickSearchIcon() {
        checkElementIsDisplayed(searchIcon);
        clickOnElement(searchIcon);
        checkElementIsDisplayed(searchInput);
    }

    @Step("Enter {0} into search input")
    public void enterSearchValue(String searchText) {
        searchInput.sendKeys(searchText);
    }

    @Step("Check search results list is visible")
    public void checkSearchResultsListIsVisible() {
        checkElementIsDisplayed(searchResultsList);
    }
}
