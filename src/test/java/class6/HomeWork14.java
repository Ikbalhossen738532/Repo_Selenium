package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeWork14 {
    /**
     * Homework 14
     * Due: Dec 3rd
     *
     * darksky.net
     * Testcase-1: Verify low/high temp on Today timeline
     *
     * hotels.com
     * Testcase-2: Verify the number of nights on black briefcase
     * checkin: tomorrow (Dec-2)
     * checkout: 7 days from checkin date (Dec-9)
     *
     * Testcase-3: Enter the user details as mentioned
     * Rooms - 1
     * Adult - 1
     * Children - 2 (Ages: 1, 2)
     * Verify user details on Search page as entered/selected on Homepage
     */
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
       WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,800)");
        driver.findElement(By.xpath("//a[@data-day='0']//span[@class='toggle']//span[@class='open']")).click();
        WebElement getTemp= driver.findElement(By.xpath("//a[@data-day='1']/preceding::span[@class='arrow']/preceding::span[@class='temp']"));
        String tempMinText= getTemp.getText();
        System.out.println(tempMinText);
        String[] tempMin = tempMinText.split("˚");
        String minTemp = tempMin[0];  //36
        System.out.println(minTemp);
    }
}
