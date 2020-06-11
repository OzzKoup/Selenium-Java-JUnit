package temchenko.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeDriverSettings {
    public WebDriver chromeDriver;
    public WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, 10);
    }

    @After
    public void close() {
        chromeDriver.close();
    }
}
