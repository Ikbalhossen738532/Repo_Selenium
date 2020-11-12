package Class1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Simple {

    @Test
    public void launchPage(){
      System.setProperty("webdriver.chrome.driver","./driver.exe/chromedriver");

        WebDriver driver = new ChromeDriver();
        /**
         * WebDriver driver --> driver is a variable of WebDriver type.
         * new ChromeDriver() --> creating object of ChromeDriver class.
         *
         * String the object of ChromeDriver class into WebDriver variable.
         *
         * ChromeDriver extends RemoteWebDriver; RemoteWebDriver implements WebDriver
         *
         */

        /**
         * get method: To launch a webpage
         */
        driver.get("https://www.facebook.com");

    }


}
