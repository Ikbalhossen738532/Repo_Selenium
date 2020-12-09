package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HW_13_Solution {
    @Test
    public void Testcase_1(){
//1
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
//2
        WebElement bellIcon =
                driver.findElement(By.xpath("//label[@for='ybarNotificationMenu']")
                );
        Actions act = new Actions (driver);
        act.moveToElement(bellIcon).build().perform();
        //3
        WebElement notifications =
                driver.findElement(By.xpath("//span[text()='Get alerts for breaking news and top stories']"));
        Actions act1 = new Actions (driver);
        act1.moveToElement(notifications).build().perform();
        act1.click(notifications).build().perform();
    }

    @Test
    public void TestCase_2(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[text()='Create New Account']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        WebElement firstName=
                driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Fname");
        WebElement lastName=
                driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Lname");
        WebElement email =
                driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']"));
        email.sendKeys("abcd@test.com");
        WebElement reEnteremail =
                driver.findElement(By.xpath("//input[@aria-label='Re-enter email']"));
        reEnteremail.sendKeys("abcd@test.com");
        WebElement password =
                driver.findElement(By.xpath("//input[@aria-label='New password']"));
        password.sendKeys("abcd@1234");
        WebElement monthName= driver.findElement(By.id("month"));
        Select month = new Select(monthName);
        month.selectByVisibleText("Feb");
        WebElement dayElm = driver.findElement(By.id("day"));
        Select day = new Select(dayElm);
        day.selectByValue("4");
        WebElement yearElm = driver.findElement(By.id("year"));
        Select year = new Select(yearElm);
        year.selectByIndex(5); //2015
        WebElement signUp =
                driver.findElement(By.id("//button[@name='websubmit']"));
//signUp.click();
        Actions act = new Actions (driver);
        act.moveToElement(signUp).build().perform();
        act.click(signUp).build().perform();

    }
}
