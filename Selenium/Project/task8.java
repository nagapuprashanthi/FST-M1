package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class task8 {

    // Contact the admin
    // Goal: Navigate to the “Contact Us” page and complete the form
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
    public void contactUsPage() {

        // Find the navigation bar
        // Select the menu item that says “Contact” and click it
        driver.findElement(By.linkText("Contact")).click();

        // Find the contact form fields (Full Name, email, etc.)
        // Fill in the information and leave a message
        driver.findElement(By.cssSelector("input[name='wpforms[fields][0]']")).sendKeys("Harry Potter");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ppp@example.com");
        driver.findElement(By.cssSelector("input[name='wpforms[fields][3]']")).sendKeys("test");
        driver.findElement(By.cssSelector("textarea[name='wpforms[fields][2]']")).sendKeys("Contact form fields");

        // Click submit
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Read and print the message displayed after submission
        WebElement message = driver.findElement(By.xpath("//*[@id='uagb-column-3c1a3492-d74d-4e1e-b35b-69d0e288d4ca']/div/div/p"));
        String displayedMessage = message.getText();
        System.out.println("Message displayed after submission: " + displayedMessage);
    }

    @AfterClass
    public void afterMethod() {

        // Close the browser
        driver.quit();

    }
}
