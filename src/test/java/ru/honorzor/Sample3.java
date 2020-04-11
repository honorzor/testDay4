package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample3 extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/test/upload/";
    private static final String MESSAGE = "1 file has been successfully uploaded.";

    @Test
    public void uploadTest() {
        driver.get(URL);
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("/home/ivan/Рабочий стол/testupload/ter.txt");

        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
        WebElement element = driver.findElement(By.cssSelector("#res"));

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();

        webDriverWait.until(ExpectedConditions.attributeContains(element, "style", "display: block"));

        boolean successfully = resultText.getText().contains("successfully");

        Assert.assertTrue(successfully);


    }
}
