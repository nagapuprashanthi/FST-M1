package project;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class task1 {

    // Verify the website title
    // Goal: Read the title of the website and verify the text


    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        // Navigate to ‘https://alchemy.hguy.co/lms’
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void homePageTest() {

        // Get the title of the website
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is:" + pageTitle);

        // Make sure it matches "Alchemy LMS – An LMS Application" exactly
        // Assert.assertEquals(pageTitle,"Alchemy LMS – An LMS Application");

        assertTrue(pageTitle.contains("Alchemy LMS – An LMS Application"));

    }

    @AfterClass
    // Close the browser
    public void tearDown() {
        // If it matches, close the browser
        driver.quit();

    }

}
