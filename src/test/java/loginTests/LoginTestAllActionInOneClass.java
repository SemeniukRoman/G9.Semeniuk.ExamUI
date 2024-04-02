package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestAllActionInOneClass {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // скачує виконуваний файл
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Browser was opened");

    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

    @Test
    public void validLogin() {
        webDriver.get("https://navi.gg/ua");
        logger.info("Site was opened");

        webDriver.findElement(By.xpath(".//a[@class='login__link']")).click();
        logger.info("Button Sign In was found");

        WebElement inputUserNameLoginForm =
                webDriver.findElement(By.xpath(".//input[@name='username']"));
        inputUserNameLoginForm.clear();
        inputUserNameLoginForm.sendKeys("Testerenko");
        logger.info("'Testerenko' was inputted into input UserName");

        WebElement inputPasswordLoginForm =
                webDriver.findElement((By.xpath(".//input[@name='password']")));
        inputPasswordLoginForm.clear();
        inputPasswordLoginForm.sendKeys("Test12345");
        logger.info("Password was inputted into input Password");

        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        logger.info("Button Sign In was clicked");
    }
}
