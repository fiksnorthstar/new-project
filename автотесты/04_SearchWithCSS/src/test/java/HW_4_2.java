import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_4_2 {

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

    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("notification-email");

    @Test
    public void testKittens() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");

        var email = "test@test.ru";

        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();

        Assert.assertTrue("Не отобразился текст про e-mail" , driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про e-mail", email, driver.findElement(resultEmailLocator).getText());

    }

    @Test
    public void testKittensEmptyEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");

        driver.findElement(writeToMeLocator).click();

        Assert.assertEquals("Неправильный текст про e-mail", "", driver.findElement(resultEmailLocator).getText());

    }

    private By emailLocatorDogs = By.name("email");
    private By writeToMeLocatorDogs = By.id("sendMe");
    private By resultEmailLocatorByDogs = By.className("your-email");

    @Test
    public void testDogs() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");

        var email = "test@test.ru";

        driver.findElement(emailLocatorDogs).sendKeys(email);
        driver.findElement(writeToMeLocatorDogs).click();

        Assert.assertTrue("Не отобразился текст про e-mail" , driver.findElement(resultEmailLocatorByDogs).isDisplayed());
        Assert.assertEquals("Неправильный текст про e-mail", email, driver.findElement(resultEmailLocatorByDogs).getText());

    }

    @Test
    public void testDogsEmptyEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");

        driver.findElement(writeToMeLocatorDogs).click();

        Assert.assertEquals("Неправильный текст про e-mail", "", driver.findElement(resultEmailLocatorByDogs).getText());

    }


}
