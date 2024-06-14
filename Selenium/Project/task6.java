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

public class task6 {
    WebDriver driver;
    // Logging into the site
    // Goal: Open the website and log-in using the provided credentials.

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
    public void loginButton() {
        // Find the navigation bar
        // Select the menu item that says “My Account” and click it
        WebElement navigationBar = driver.findElement(By.linkText("My Account"));
        String navigationBarText = navigationBar.getText();
        System.out.println("Navigation bar text is: " + navigationBarText);
        navigationBar.click();

        // Read the page title and verify that you are on the correct page
        String currentPageTitle = driver.getTitle();
        System.out.println("Current Page Title is: " + currentPageTitle);
        assertTrue(currentPageTitle.contains(navigationBarText));

        // Find the “Login” button on the page and click it
        driver.findElement(By.className("ld-login-text")).click();

        // Find the username field of the login form and enter the username into that field
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");

        // Find the password field of the login form and enter the password into that field
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("pa$$w0rd");

        // Find the login button and click it
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // Verify that you have logged in
        WebElement verification = driver.findElement(By.linkText("Edit profile"));
        String verifyLogin = verification.getText();
        Assert.assertEquals(verifyLogin, "Edit profile");
        System.out.println("Verify Edit profile is coming: " + verifyLogin);
    }

    @AfterClass
    public void afterMethod() {
        // Close the browser
        driver.quit();
    }
}
