package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Sample4 extends SettingsDriver {
    private static final String URL = "http://demo.guru99.com/test/yahoo.html";

    @Test
    public void downloadFileFromWeb() {
        driver.get(URL);

        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wgetCommand = "wget -P /home/ivan/Загрузки/wget --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
            Assert.assertEquals(exitVal,0);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
