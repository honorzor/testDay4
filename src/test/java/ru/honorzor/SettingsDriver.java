package ru.honorzor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SettingsDriver {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @BeforeClass
    public void signUp (){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver,10);
    }

    @AfterClass
    public void closeSession (){
        driver.quit();
    }
}
