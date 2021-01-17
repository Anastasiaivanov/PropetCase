package com.propet;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("http://propets-frontend.herokuapp.com/propets");
    }

    @Test
    public void logIn() throws InterruptedException {
        click(By.cssSelector("*[class*='header-signin-btn']"));
        type(By.cssSelector("[name=name]"), "Ana");
        type(By.cssSelector("[name=emailReg]"), "ana@mail.com");
        type(By.cssSelector("[name=passwordReg]"), "Ana@mail1236");
        type(By.cssSelector("[name=passwordReg2]"), "Ana@mail1236");
        click(By.cssSelector("[type=submit]"));
        Thread.sleep(1000);
        String parentWindowHandler = wd.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = wd.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()){
            subWindowHandler=iterator.next();
        }
        wd.switchTo().window(subWindowHandler);
        Thread.sleep(6000);
        click(By.cssSelector("*[class*='btn-signin']"));
        type(By.cssSelector("[name=email]"), "ana@mail.com");
        type(By.cssSelector("[name=password]"), "Ana@mail1236");
        click(By.cssSelector("[type=submit]"));

        Assert.assertNotNull(wd.findElement(By.cssSelector(".fas fa-sign-out-alt")));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        wd.quit();
    }
}
