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

import static org.testng.AssertJUnit.assertTrue;

public class task9 {

    // Complete a simple lesson
    // Goal: Navigate to a particular lesson and complete it
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open a browser
        // Navigate to ‘https://alchemy.hguy.co/lms’
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyTitleOfCourse() {
        // Find the navigation bar.
        // Select the menu item that says “My Account” and click it.
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.className("ld-login-button")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.cssSelector("input[name='wp-submit']")).click();

        // Select the menu item that says “All Courses” and click it.
        driver.findElement(By.linkText("All Courses")).click();

        // Select any course and open it
        driver.findElement(By.xpath("//*[@class='ld-course-list-items row']/div[1]")).click();

        // Click on a lesson in the course. Verify the title of the course.
        // driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[1]/div[1]/div/div/span[2]")).click();
        // driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div[1]/a/span")).click();

        driver.findElement(By.xpath("//*[@id='ld-expand-83']/div[1]/a/div[2]")).click();
        String courseTitle = driver.getTitle();
        System.out.println("Title of the course is: " + courseTitle);
        assertTrue(courseTitle.contains("Developing Strategy"));
    }

    @AfterClass
    public void afterMethod() {
        // Close the browser
        driver.quit();

    }
}
