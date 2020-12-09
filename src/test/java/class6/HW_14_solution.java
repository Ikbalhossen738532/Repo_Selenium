package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HW_14_solution  {
    @Test
    public void Testcase1(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://darksky.net/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0.1000)");
        WebElement highTempT =
                driver.findElement(By.xpath("//span[@class='high-temp-text']"));
        String highTempText = highTempT.getText();
        int degIndex1 = highTempText.indexOf(" ̊");
        String highTempValue = highTempText.substring(0,degIndex1);
        int highTemp = Integer.valueOf(highTempValue);
        WebElement lowTempT =
                driver.findElement(By.xpath("//span[@class='low-temp-text']"));
        String lowTempText = lowTempT.getText();
        int degIndex2 = lowTempText.indexOf(" ̊");
        String lowTempValue = lowTempText.substring(0,degIndex2);
        int lowTemp = Integer.valueOf(lowTempValue);
        WebElement maxTemp =
                driver.findElement(By.xpath("//span[text()='44 ̊']/preceding-sibling ::span[@style='width:42%; margin-left:1%']"));
        String maxTempText = maxTemp.getText();
        int degIndex3 = maxTempText.indexOf(" ̊");
        String maxTempValue = maxTempText.substring(0,degIndex3);
        int maxTempToday = Integer.valueOf(maxTempValue);
        WebElement minTemp =
                driver.findElement(By.xpath("//span[@class='minTemp']/following-sibling::span[@style='width:42%; margin-left:1%']"));
        String minTempText = minTemp.getText(); // "36 ̊"
        int degIndex4 = minTempText.indexOf(" ̊");
        String minTempValue = minTempText.substring(0,degIndex4);
        int minTempToday = Integer.valueOf(minTempValue); // 36

        Assert.assertEquals(highTemp,maxTempToday,"High temp is not equal to today's max temperature");
        Assert.assertEquals(lowTemp,minTempToday,"Low temp is not equal to today's min temperature");
    }
    @Test
    public void Testcase2 (){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");

        driver.findElement(By.id("qf-0q-localised-check-in")).click();
        List<WebElement> datesIn =
                driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckIn = "2";
        for (WebElement date : datesIn) {
            if (date.getText().equalsIgnoreCase(userCheckIn)) {
                date.click();
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        List<WebElement> datesOut =
                driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckOut = "9";
        for (WebElement date : datesOut) {
            if (date.getText().equalsIgnoreCase(userCheckOut)) {
                date.click();
                break;
            }
        }

        WebElement elementInBlackBrief =
                driver.findElement(By.xpath("//span[@class='widget-query-num-nights ']"));
        String noInBlackBrief = elementInBlackBrief.getText();
        int userCheckInInt = Integer.parseInt("2");
        int userCheckOutInt = Integer.parseInt("9");
        int noInBriefcase = userCheckOutInt-userCheckInInt;
        Assert.assertEquals(noInBlackBrief,noInBriefcase,"The number of nights on black briefcase is wrong");
    }
    @Test
    public void Testcase3(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");
        driver.findElement(By.id("qf-0q-destination")).clear();
        driver.findElement(By.id("qf-0q-destination")).sendKeys("Union Square");
                String select ="Union Square, Lakewood, Colorado, United States of America";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        By autoSuggestionsLocator =
                By.xpath("//div[@class='autosuggest-category-result']");
        List<WebElement> suggestions =
                driver.findElements(autoSuggestionsLocator);
        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            if (select.equalsIgnoreCase(suggestionText)) {
                suggestion.click();
                break;

            }
        }

        driver.findElement(By.id("qf-0q-localised-check-in")).click();
        List<WebElement> datesIn =
                driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckIn = "2";
        for (WebElement date : datesIn) {
            if (date.getText().equalsIgnoreCase(userCheckIn)) {
                date.click();
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        List<WebElement> datesOut =
                driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        String userCheckOut = "9";
        for (WebElement date : datesOut) {
            if (date.getText().equalsIgnoreCase(userCheckOut)) {
                date.click();
                break;
            }
        }
        WebElement elementInBlackBrief =
                driver.findElement(By.xpath("//span[@class='widget-query-num-nights ']"));
        String noInBlackBrief = elementInBlackBrief.getText();
        WebElement room =
                driver.findElement(By.className("query-rooms"));
        Select roomNo = new Select(room);
        roomNo.selectByIndex(1);

        WebElement adults =
                driver.findElement(By.id("qf-0q-room-0-adults"));
        Select adultsNo = new Select(adults);
        adultsNo.selectByIndex(1);
        WebElement children =
                driver.findElement(By.id("qf-0q-room-0-children"));
        Select childNo = new Select(children);
        childNo.selectByIndex(2);
        WebElement child1 =
                driver.findElement(By.xpath("//select[@id='qf-0q-room-0-child-0-age ']"));
        Select childAge1 = new Select(child1);
        childAge1.selectByIndex(1);
        WebElement child2 =
                driver.findElement(By.xpath("//select[@id='qf-0q-room-0-child-1-age ']"));
        Select childAge2 = new Select(child2);
        childAge2.selectByIndex(2);
        WebElement expectedDetails =
                driver.findElement(By.xpath("//button[text()='Search']"));
        expectedDetails.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        WebElement homepageResult =
                driver.findElement(By.xpath("//button[@class='cta cta-strong']"));
        homepageResult.click();
        Assert.assertEquals(expectedDetails,homepageResult,"User details are not matched as entered on Search page");
    }
}
