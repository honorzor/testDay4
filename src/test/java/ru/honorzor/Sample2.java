package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample2 extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/test/login.html";

    @Test(priority = 1)
    public void setEmailAndPassword() {
        driver.get(URL);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("passwd"));
        //set login and password
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        //clear textfield
        email.clear();
        password.clear();

    }

    @Test(priority = 2)
    public void registrationUser() throws InterruptedException {
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("passwd"));
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        WebElement element = driver.findElement(By.className("error-box"));

        Assert.assertTrue(element.isDisplayed());
    }


}
