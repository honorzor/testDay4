package ru.honorzor;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstE2ETest extends SettingsDriver {
    private static final String EXCEPTEDTITLE = "Welcome: Mercury Tours";
    private static final String EXCEPTEDTEXT = "Demo Site";
    private static final String URL = "http://demo.guru99.com/test/newtours/";


    @Test
    public void verifyHomepageTitle() {
        driver.get(URL);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, EXCEPTEDTITLE);
    }

    @Test
    public void verifyMainLabel() {
        String actualText = driver.findElement(By.cssSelector("#site-name > a")).getText();
        Assert.assertEquals(actualText, EXCEPTEDTEXT);
    }


}