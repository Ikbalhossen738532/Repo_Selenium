package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledDisplayedSelected {
   @Test
    public void isElementDisplayed() {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
       WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        /**
         * To verify if webElement is Displayed or not
         * Method: isDisplayed()
         * Return type: boolean
         */

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        boolean isLoginButtonDisplayed = loginButton.isDisplayed();

       Assert.assertTrue(isLoginButtonDisplayed, "Login button is not displayed");

    }

    @Test
    public void isElementEnabled() {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        /**
         * To verify if webElement is Enabled or not
         * Method: isEnabled()
         * Return type: boolean
         */

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        boolean isLoginButtonEnabled = loginButton.isEnabled();

        Assert.assertTrue(isLoginButtonEnabled, "Login button is not enabled");

    }

    @Test
    public void isElementSelected() {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        /**
         * To verify if webElement is Selected or not
         * Method: isSelected()
         * Return type: boolean
         */
        /**
         * Test Scenario: Verify gender is not selected
         * 1. Launch facebook.com
         * 2. Click on 'Create New Account'
         * 3. Verify Male radio button is not selected
         * 4. Select Male-radio button ONLY if it not selected
         * 5. Verify Male radio button is selected
         */
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected(), "");
        if(!driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected()) {
            driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected(), "");



        driver.findElement(By.linkText("Create New Account")).click();
        WebElement df = driver.findElement(By.xpath("//input[@type='radio']/preceding-sibling::label[text()='Female']"));
        boolean isSelected = df.isSelected();
        Assert.assertTrue(isSelected, "Else is not selected");


        WebElement CreateAccLoc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        CreateAccLoc.click();
        WebElement maleButtonLoc =  driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input"));

        Assert.assertFalse(maleButtonLoc.isSelected(), "");

        if (!maleButtonLoc.isSelected()) {
            maleButtonLoc.click();
        }

        Assert.assertTrue(maleButtonLoc.isSelected(), "");




    }

}
