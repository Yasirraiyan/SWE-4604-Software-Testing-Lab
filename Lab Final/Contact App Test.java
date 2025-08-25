import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class ContactAppTest
{
    WebDriver driver;
    void SetUp()
    {
        driver=new ChromeDriver();
        driver.manage.window.maximize();
    }
    void tearDown()
    {
        driver.quit();
    }
    void testInvalidEmailSignUp()
    {
        driver.get("https://thinking-tester-contact-list-.herokuapp.com/addUser");
        driver.findElement(By.id("firstName")).sendKeys("Mamun");
        driver.findElement(By.id("lastName")).sendKeys("Ahmed");
        driver.findElement(By.id("email")).sendKeys("yasir123");
        driver.findElement(By.Id("password")).sendKeys("12345678"));
driver.findElement(By.Id("submit")).click();



    }
}
