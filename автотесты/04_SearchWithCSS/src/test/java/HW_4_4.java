import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_4_4 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private By locatorName = By.cssSelector(".form-input.fio");
    private By locatorStreet = By.cssSelector(".form-input.street");
    private By locatorHouse = By.cssSelector(".form-input.house");
    private By locatorRoom = By.cssSelector(".form-input.flat");
    private By locatorDay = By.cssSelector(".form-input.date");


    @Test
    public void positiveTest () {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");

        driver.findElement(locatorName).sendKeys("Коля");
        driver.findElement(locatorStreet).sendKeys("Кремневая");
        driver.findElement(locatorHouse).sendKeys("54");
        driver.findElement(locatorRoom).sendKeys("0");
        driver.findElement(locatorDay).sendKeys("вчера");
        driver.findElement(By.className("form-submit")).click();

        var locatorMessage = driver.findElement(By.className("form-result-data")).isDisplayed();
        Assert.assertEquals(true, locatorMessage);

    }
}
