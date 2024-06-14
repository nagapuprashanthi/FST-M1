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

public class task3 {

    WebDriver driver;

    // Verify the title of the first info box
    //Goal: Read the title of the first info box on the website and verify the text
    @BeforeClass
    public void beforeMethod() {

        // Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        // Open a browser.
        //Navigate to ‘https://alchemy.hguy.co/lms’.
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void titleOfFirstInfoBox() {

        // Get the title of the first info box
        WebElement title = driver.findElement(By.xpath("//*[@id='uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810']/div/div/div/div[2]/h3"));
        String titleInfoBox;
        titleInfoBox = title.getText();
        System.out.println("Title of the first info box is: " + titleInfoBox);

        // Make sure it matches “Actionable Training” exactly
        Assert.assertEquals(titleInfoBox, "Actionable Training");
    }

    @AfterClass
    public void afterMethos() {
        //  If it matches, close the browser.
        driver.quit();
    }
}
