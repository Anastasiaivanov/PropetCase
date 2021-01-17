package com.propet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignInTest extends TestBase{
    
    @Test
    public void signIn(){
        click(By.cssSelector("*[class*='header-signin-btn']"));
        click(By.cssSelector("*[class*='btn-signin']"));
        type(By.cssSelector("[name=email]"), "ana@mail.com");
        type(By.cssSelector("[name=password]"), "Ana@mail1236");
        click(By.cssSelector("[type=submit]"));
    }
}
