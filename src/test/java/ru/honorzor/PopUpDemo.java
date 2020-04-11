package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class PopUpDemo extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/popup.php";

    @Test
    public void getNewWindow() {
        driver.get(URL);
        driver.findElement(By.cssSelector("body > p > a")).click();

        String windowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String win : windowHandles) {
            if (!windowHandle.equalsIgnoreCase(win)) {
                driver.switchTo().window(win);
                driver.findElement(By.name("emailid")).sendKeys("testforQA@mail.ru");
                driver.findElement(By.name("btnLogin")).click();

                webDriverWait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement element = driver.findElement(By.cssSelector("body > table > tbody > tr:nth-child(6) > td"));
                Assert.assertTrue(element.isDisplayed());

                driver.close();

            }
        }
        driver.switchTo().window(windowHandle);

    }
}
