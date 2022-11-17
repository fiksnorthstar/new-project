import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_4_3 {

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

    private By locatorName = By.cssSelector(".data.text");
    private By locatorMail = By.cssSelector(".data.field");
    private By locatorText = By.cssSelector(".field.text");
    private By message = By.cssSelector(".message-description.comment");

    @Test
    public void testFeedBack (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");

        driver.findElement(locatorName).sendKeys("Коля");
        driver.findElement(locatorMail).sendKeys("test@test.ru");
        driver.findElement(locatorText).sendKeys("Тарам-пам-пам");
        driver.findElement(By.id("comment")).click();

        Assert.assertTrue(driver.findElement(message).isDisplayed());


    }

}
