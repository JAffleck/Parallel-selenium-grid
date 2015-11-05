package Parallel.GridDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests extends TestBase {
    @Test
    public void test1() throws Exception {
        WebDriver driver = getDriver();
        driver.get("http://facebook.com");
        WebElement textBox = driver.findElement(By.cssSelector("input#email"));
        textBox.click();
        textBox.sendKeys("Just a test!");
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://twitter.com");
        WebElement textBox = driver.findElement(By.cssSelector("[class^=StreamsHero] > button"));
        textBox.click();
        textBox.sendKeys("Just another test!");
        Thread.sleep(2000);
    }

    @Test
    public void test3() throws Exception {
        WebDriver driver = getDriver();
        driver.get("http://facebook.com");
        WebElement textBox = driver.findElement(By.cssSelector("input[aria-label*='Re-enter email']"));
        textBox.click();
        textBox.sendKeys("Test three!");
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws Exception {
        WebDriver driver = getDriver();
        driver.get("http://facebook.com");
        WebElement textBox = driver.findElement(By.cssSelector("input[aria-label^='Email']"));
        textBox.click();
        textBox.sendKeys("Test 4!");
        Thread.sleep(2000);
    }
}
