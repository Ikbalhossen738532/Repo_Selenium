package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Interaction {
    @Test
    public void ActionsInteractions() {
        // Actions
        /**
         * mouseHover -> moveToElement()
         * drag and drop -> dragAndDrop()
         * right click -> contextClick()
         * double click -> doubleClick()
         */

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }

        WebElement bellIcon = driver.findElement(By.id("ybarNotificationMenu"));

        Actions act = new Actions(driver);

        // act.moveToElement(bellIcon).perform();
        act.moveToElement(bellIcon).build().perform();
        /**
         * build().perform() vs .perform()
         *
         * when method is doing only 1 action --> .perform() is enough
         *  [but you can use .build().perform() also]
         *
         * when method is doing more than 1 action --> .build().perform()
         *
         */

        // act.click(bellIcon).build().perform();





    }

}
