package hw1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerTest {
    public static void main(String[] args) {
        new WebDriverManagerTest().testDriverManagerChrome();

    }

    public void testDriverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://otus.ru/");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
