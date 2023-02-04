import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.HTMLDocument;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OneTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("https://grc.eplat4m.ru/");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void oneTestNegative() {
        driver.findElement(By.cssSelector("#UserName")).sendKeys("САПУИБ\\NotExist");
        driver.findElement(By.cssSelector("#passwordId")).sendKeys("123456");
        driver.findElement(By.cssSelector("#cb2")).click();
        driver.findElement(By.cssSelector("#ddl1")).click();

        var element = By.cssSelector("#ddl1 option:first-child");
        while (driver.findElements(element).size()==0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.findElement((By) element).click();

        driver.findElement(By.cssSelector("#btnLogin")).click();
        var text = driver.findElement(By.cssSelector("div.validation-summary-errors")).getText();
        Assert.assertEquals("Неправильный способ входа, имя пользователя или пароль.", text);
    }


    @Test
    public void oneTestPositive() {
        driver.findElement(By.cssSelector("#UserName")).sendKeys("САПУИБ\\test2");
        driver.findElement(By.cssSelector("#passwordId")).sendKeys("654321");
        driver.findElement(By.cssSelector("#btnLogin")).click();

        var element = By.cssSelector(".nav-tabs li:first-child");
        while (driver.findElements(element).size()==0){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var text = driver.findElement(element).getText();
        Assert.assertEquals("Соответствие требованиям", text);


    }

}
