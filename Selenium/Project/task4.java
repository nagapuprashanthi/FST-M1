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

public class task4 {

    WebDriver driver;
    // Verify the title of the second most popular course
    // Goal: Read the title of the second most popular course on the website and verify the text

    @BeforeClass
    public void beforeMethod() {
        //Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open a browser.
        // Navigate to ‘https://alchemy.hguy.co/lms’
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void secondMostPopularCourse() {
        // Get the title of the second most popular course
        WebElement title = driver.findElement(By.xpath("//*[@id='post-71']/div[2]/h3"));
        String titleOfSecondCourse;
        titleOfSecondCourse = title.getText();
        System.out.println("Title of the second most popular course is: " + titleOfSecondCourse);

        // Make sure it matches “Email Marketing Strategies” exactly
        Assert.assertEquals(titleOfSecondCourse, "Email Marketing Strategies");
    }

    @AfterClass
    public void afterMethod() {
        // If it matches, close the browser
        driver.quit();
    }
}
