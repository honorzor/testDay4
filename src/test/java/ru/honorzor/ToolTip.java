package ru.honorzor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolTip extends SettingsDriver {

    private static final String URL = "http://demo.guru99.com/test/social-icon.html";
    private static final String EXCEPTEDTEXT = "Github";

    @Test
    public void tool() {
        driver.get(URL);

        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        String actualTooltip = github.getAttribute("title");

        Assert.assertEquals(actualTooltip, EXCEPTEDTEXT);
    }
}
