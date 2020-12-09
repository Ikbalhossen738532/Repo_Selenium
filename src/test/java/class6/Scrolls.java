package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolls {
    public void scrolls() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");


        /**
         * Use javascript to scroll
         *
         * scroll by pixel
         * scroll upto a webElement
         * scroll to bottom
         */

        /**
         * scroll by pixel
         */
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // type-casting - changing the driver-datatype into JavaScriptExecutor and
        // storing in JavaScriptExecutor variable.
        js.executeScript("scrollBy(0,700);");   // scroll downward 700 pixels
        Thread.sleep(500);
        js.executeScript("scrollBy(0,-700);");   // scroll upward 700 pixels


        /**
         * scroll upto a particular webElement
         */
      WebElement elem = driver.findElement(By.id(""));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);


        /**
         * scroll to bottom
         */
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

    }
}
