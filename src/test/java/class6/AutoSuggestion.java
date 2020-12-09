package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AutoSuggestion {
    @Test
    public void autoSuggestion() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");

        driver.findElement(By.id("qf-0q-destination")).clear();
        driver.findElement(By.id("qf-0q-destination")).sendKeys("times square");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String toSelect = "times SqUAre, New York, New York, United States of America";

        /**
         * 1. Analyze if auto-suggestions are present in dom as text or attribute
         * 2. Create a locator that will point to all the auto-suggestion webElements
         * 3. using 'findElements' method to find all the auto-suggestion webElements
         * 4.
         *   pick element-1
         *      get text of element-1
         *      if (text == toSelect)
         *          element-1.click()
         *          break
         *   pick element-2
         *      get text of element-2
         *      if (text == toSelect)
         *          element-2.click()
         *          break
         *      ....
         *      ....
         */

        By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
        List<WebElement> suggestions = driver.findElements(autoSuggestionsLocator);

        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            if (toSelect.equalsIgnoreCase(suggestionText)) {
                suggestion.click();
                break;
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // driver.findElement(By.id("qf-0q-localised-check-in")).click();
        // driver.findElement(By.xpath("//td[@data-date='2020-11-1']")).click();

        // driver.findElement(By.id("qf-0q-localised-check-in")).click();
        // driver.findElement(By.xpath("//td[@data-date='2020-11-10']")).click();


        driver.findElement(By.id("qf-0q-localised-check-in")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckIn = "10";

        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase(userCheckIn)) {
                date.click();
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckOut = "20";

        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase(userCheckOut)) {
                date.click();
                break;
            }
        }




    }
}
