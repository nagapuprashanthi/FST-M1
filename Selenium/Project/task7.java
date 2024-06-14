package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class task7 {

    // Count the number of courses
    // Goal: Navigate to the “All Courses” page and count the number of courses
    WebDriver driver;

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
    public void numberOfCoursesOnPage() {

        // Find the navigation bar
        // Select the menu item that says “All Courses” and click it.
        driver.findElement(By.linkText("All Courses")).click();

        // Find all the courses on the page.
        // Print the number of courses on the page
        List<WebElement> courses = driver.findElements(By.xpath("//*[@class='ld-course-list-items row']/div"));
        System.out.println("Number of courses on the page: " + courses.size());
    }


    @AfterClass
    public void afterMethod() {
        // Close the browser
        driver.quit();
    }
}
