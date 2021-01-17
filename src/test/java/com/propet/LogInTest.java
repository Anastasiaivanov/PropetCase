package com.propet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {

    @Test
    public void logIn() throws InterruptedException {
        click(By.cssSelector("*[class*='header-signin-btn']"));
        type(By.cssSelector("[name=name]"), "Ana");
        type(By.cssSelector("[name=emailReg]"), "ana@mail.com");
        type(By.cssSelector("[name=passwordReg]"), "Ana@mail1236");
        type(By.cssSelector("[name=passwordReg2]"), "Ana@mail1236");
        click(By.cssSelector("[type=submit]"));
        Thread.sleep(2000);
        wd.switchTo().alert().accept();

        //Assert.assertNotNull(wd.findElement(By.cssSelector(".fas fa-sign-out-alt")));
    }
}
