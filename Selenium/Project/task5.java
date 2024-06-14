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

import java.awt.*;

import static org.testng.AssertJUnit.assertTrue;

public class task5 {
    WebDriver driver;
    // Navigate to another page
    // Goal: Navigate to the “My Account” page on the site.

    @BeforeClass
    public void beforeMethod() {
        // Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open a browser.
        // Navigate to ‘https://alchemy.hguy.co/lms’
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void clickMyAccount() {

        //  Find the navigation bar
        // Select the menu item that says “My Account” and click it
        WebElement navigationBar = driver.findElement(By.linkText("My Account"));
        String navigatorBarText = navigationBar.getText();
        System.out.println("Navigation bar text is: " + navigatorBarText);
        navigationBar.click();

        // Read the page title and verify that you are on the correct page
        String currentPageTitle = driver.getTitle();
        System.out.println("Current page Title is: " + currentPageTitle);
        assertTrue(currentPageTitle.contains(navigatorBarText));
    }

    @AfterClass
    public void afterMethod() {
        //  Close the browser
        driver.quit();
    }
}
