package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class task2 {

    // Verify the website heading
    //Goal: Read the heading of the website and verify the text
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create new instance of firefox driver
        driver = new FirefoxDriver();
        // Open the browser
        // Navigate to ‘https://alchemy.hguy.co/lms’
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void headingOfWebpage() {
        // Get the heading of the webpage
        WebElement heading = driver.findElement(By.xpath("//*[@id='uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896']/div/div/div/div[1]/h1"));
        String headingText = heading.getText();
        // Make sure it matches “Learn from Industry Experts” exactly
        Assert.assertEquals(headingText, "Learn from Industry Experts");
    }

    @AfterClass
    public void afterMethod() {
        // If it matches, close the browser.
        driver.quit();
    }
}
