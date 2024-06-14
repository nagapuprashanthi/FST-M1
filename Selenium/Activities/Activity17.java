package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Get the title of the page and print it to the console.
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        // Find the select WebElement
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        // Select the second option using the visible text.
        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        // Select the third option using the index.
        dropdown.selectByIndex(3);
        // Select the fourth option using the value.
        dropdown.selectByValue("4");
        // Get all the options and print them to the console.
        System.out.println("The options are : ");
        for(WebElement option : dropdown.getOptions()){
            System.out.println(option.getText());
        }

        // close the browser
        driver.quit();
    }
}