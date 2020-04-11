package ru.honorzor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertDemo extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/test/delete_customer.php";
    private static final String EXCEPTEDMESSAGEONE = "Do you really want to delete this Customer?";
    private static final String EXCEPTEDMESSAGETWO = "Customer Successfully Delete!";

    @Test
    public void goToWeb() {
        driver.get(URL);
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        webDriverWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actual = alert.getText();

        Assert.assertEquals(actual, EXCEPTEDMESSAGEONE);
        alert.accept();

        webDriverWait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();

        String actualMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(actualMessage, EXCEPTEDMESSAGETWO);

        alert2.accept();

    }


}