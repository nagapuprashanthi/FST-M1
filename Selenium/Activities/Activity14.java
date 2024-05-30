package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity14 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the page is: " + driver.getTitle());
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        dropdown.selectByVisibleText("option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("4");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        System.out.println("The options are:");
        for (WebElement option : dropdown.getOptions()){
            System.out.println(option.getText());
            driver.quit();
        }
    }
}
