package hw2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class TestLinkLocator {
    private static final Logger logger = LogManager.getLogger(hw1.WebDriverManagerTest.class);
    private  WebDriver driver;


    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testlinkpage() {
        driver.get("http://localhost/testlink");
        driver.findElement(By.cssSelector("#tl_login")).click();
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).click();
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[3]/input")).click();
        logger.debug("info");
        driver.findElement(By.xpath("//a[@href = 'http://localhost/testlink/general/frmWorkArea.php?feature=editTc']")).click();
        //driver.quit();

    }
}