package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
    @Test
    public void handleDropdown() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
       WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        /*
            1. find the locator of dropdown-webElement
            2. find the dropdown-webElement using the step #1 locator
            3. Create object of Select class    // Select s = new Select(step2WebElement);
            4. use relevant method to select desired value in dropdown
                selectByVisibleText | selectByValue | selectByIndex
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        WebElement monthElem = driver.findElement(By.id("month"));
        Select month = new Select(monthElem);
        month.selectByVisibleText("Jan");   // Jan

        WebElement dayElem = driver.findElement(By.id("day"));
        Select day = new Select(dayElem);
        // day.selectByValue("7");             // 7
        day.selectByVisibleText("7");

        WebElement yearElem = driver.findElement(By.id("year"));
        Select year = new Select(yearElem);
        year.selectByIndex(4);              // 2016





    }
}
