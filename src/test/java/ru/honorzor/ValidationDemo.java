package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationDemo extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/V1/index.php";
    private static final String VISIBILITYON = "visibility: visible;";
    private static final String VISIBILITYHIDDEN = "visibility: hidden;";


    @Test(priority = 1)
    public void styleVisible() {
        driver.get(URL);

        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement misc = driver.findElement(By.cssSelector("body"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));


        usernameControl.click();
        passwordControl.click();
        misc.click();

        Assert.assertEquals(userValidationMessage.getAttribute("style"), VISIBILITYON);
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), VISIBILITYON);
    }


    @Test(priority = 2)
    public void styleHidden() {
        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

        usernameControl.sendKeys("a");
        passwordControl.sendKeys("b");

        Assert.assertEquals(userValidationMessage.getAttribute("style"), VISIBILITYHIDDEN);
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), VISIBILITYHIDDEN);

    }

}
