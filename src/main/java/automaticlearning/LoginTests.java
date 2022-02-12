package automaticlearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests
{
    public void  invalidloginTest()
    {
        /*
        *1. open home page http://www.next.uk user should be in the homepage
        * 1.1 find the browser exe
        * 1.2 open the browser
        * 1.3 provide the url in the address bar of the browser
        * 2.click myaccount link in the header. user should be in the login page
        * 3.Enter username in the username textfield abc@gmail.com
        * 4.Enter password in the password textfield craft12
        * 5.User click sign in button should be provided with " we could not sign you in"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.next.uk");
        driver.findElement(By.id("")).click();
        //locators
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("craft12");
        driver.findElement(By.id("SignInNow")).click();

        String expectedloginErrorMsg = "we could not sign you in";
        String actualLoginErrorMsg = driver.findElement(By.xpath("//*[@id=\"pri\"]/div/div/div/div/div/span")).getText();

        Assert.assertEquals(expectedloginErrorMsg , actualLoginErrorMsg);

    }
}
