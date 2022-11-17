import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_4_5 {

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

    private By enterMail = By.id("email");
    private By enterPassword = By.name("password");
    private By button = By.className("form-submit");


    @Test
    public void testOne (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        driver.findElement(enterMail).sendKeys("@");
        driver.findElement(enterPassword).sendKeys("123");
        driver.findElement(button).click();
        var text = "Некорректный email или пароль";

        var locatorMessage = driver.findElement(By.className("form-error-password-email")).isDisplayed();
        Assert.assertTrue(locatorMessage);

        var actualResult = driver.findElement(By.className("form-error-password-email")).getText();
        Assert.assertEquals(text,actualResult);
    }

    private By enterMailUp = By.cssSelector(".form-input.input-data");
    private By enterPasswordUp = By.cssSelector(".form-input.password");
    private By buttonUp = By.id("submit");

    @Test
    public void testTwo (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(enterMailUp).sendKeys("@");
        driver.findElement(enterPasswordUp).sendKeys("123");
        driver.findElement(buttonUp).click();
        var text = "Некорректный email или пароль";

        var locatorMessage = driver.findElement(By.className("form-error-password-email")).isDisplayed();
        Assert.assertTrue(locatorMessage);

        var actualResult = driver.findElement(By.className("form-error-password-email")).getText();
        Assert.assertEquals(text,actualResult);
    }


    private By enterMailTag = By.cssSelector("input.input-data");
    private By enterPasswordTag = By.cssSelector("input.password");
    private By buttonTag = By.cssSelector("button.form-submit");

    @Test
    public void testThree (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(enterMailTag).sendKeys("@");
        driver.findElement(enterPasswordTag).sendKeys("123");
        driver.findElement(buttonTag).click();
        var text = "Некорректный email или пароль";

        var locatorMessage = driver.findElement(By.className("form-error-password-email")).isDisplayed();
        Assert.assertTrue(locatorMessage);

        var actualResult = driver.findElement(By.className("form-error-password-email")).getText();
        Assert.assertEquals(text,actualResult);
    }

    private By enterMailId = By.cssSelector("input#email");
    private By enterPasswordId = By.cssSelector("input#password");
    private By buttonId = By.cssSelector("button#submit");

    @Test
    public void testFour (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(enterMailId).sendKeys("@");
        driver.findElement(enterPasswordId).sendKeys("123");
        driver.findElement(buttonId).click();
        var text = "Некорректный email или пароль";

        var locatorMessage = driver.findElement(By.className("form-error-password-email")).isDisplayed();
        Assert.assertTrue(locatorMessage);

        var actualResult = driver.findElement(By.className("form-error-password-email")).getText();
        Assert.assertEquals(text,actualResult);
    }

    private By enterMailAll = By.cssSelector("input#email.input-data");
    private By enterPasswordAll = By.cssSelector("input#password.password");
    private By buttonAll = By.cssSelector("button#submit.form-submit");

    @Test
    public void testFive (){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(enterMailAll).sendKeys("@");
        driver.findElement(enterPasswordAll).sendKeys("123");
        driver.findElement(buttonAll).click();
        var text = "Некорректный email или пароль";

        var locatorMessage = driver.findElement(By.className("form-error-password-email")).isDisplayed();
        Assert.assertTrue(locatorMessage);

        var actualResult = driver.findElement(By.className("form-error-password-email")).getText();
        Assert.assertEquals(text,actualResult);
    }


}
