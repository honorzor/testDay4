package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
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
            exec.waitFor();
            File file = new File("/home/ivan/Загрузки/wget/msgr11us.exe");
            Assert.assertTrue(file.exists());
            file.delete();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
