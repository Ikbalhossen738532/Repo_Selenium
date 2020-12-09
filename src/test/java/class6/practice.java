package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class practice {
   @Test
    public void scrollPractice() {

        // #1
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net/");

        /**
         * 1. Launch darksky.net
         * 2. Scroll to Time Machine button (scroll by pixels)
         * 3. Click on Time Machine button
         * 4. Verify currentDate is highlighted <--
         */

        // #2
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,700);");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e) {}
        js.executeScript("scrollBy(0,700);");

        // #3
        WebElement timeMachine = driver.findElement(By.xpath("//a[@class='button']"));
        timeMachine.click();

        // #4
        WebElement element2 = driver.findElement(By.className("is-today"));
        String todayDate = element2.getText();              // "1"

        SimpleDateFormat formatter = new SimpleDateFormat("d");
        Date date = new Date();
        String actualTodayData = formatter.format(date);    // "1"


        Assert.assertEquals(todayDate, actualTodayData, "Current Date is not highlighted" );


    }
}
