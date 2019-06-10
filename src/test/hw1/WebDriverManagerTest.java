package hw1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManagerTest {
    private static final Logger logger = LogManager.getLogger(WebDriverManagerTest.class);

    @Before
    public static void main(String[] args) {
        new WebDriverManagerTest().testDriverManagerChrome();

    }

    @Test
    public void testDriverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://otus.ru/");
        logger.info("info");
        driver.quit();

    }
}