package hw2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class TestLinkLocator {
    //private static final Logger logger = LogManager.getLogger(hw2.TestLinkLocator.class);
    private WebDriver driver;


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
        driver.switchTo().frame("mainframe");
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/a[1]")).click();
        driver.switchTo().frame("workframe");
        driver.findElement(By.xpath("/html/body/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"new_testsuite\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("TestSuiteOne");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement tinymce = driver.findElement(By.tagName("body"));
        tinymce.clear();
        tinymce.sendKeys("Test suite description");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("mainframe");
        //driver.findElement(By.className("option_transfer_container")).click();
        driver.switchTo().frame("workframe");
        driver.findElement(By.name("add_testsuite_button")).click();
        driver.quit();

    }
}