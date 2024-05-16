package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver() ;
        driver.get("https://training-support.net/");
        String pageTitle= driver.getTitle();
        System.out.println(pageTitle);
        driver.findElement(By.linkText("About Us")).click();
        String pageTitle1= driver.getTitle();
        System.out.println(pageTitle1);
        Thread.sleep(2000);
        driver.quit();

    }
}
