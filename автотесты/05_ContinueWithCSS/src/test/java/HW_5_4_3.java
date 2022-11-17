import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_5_4_3 {

    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    private By one = By.cssSelector(".important-section-block > h1:first-child");
    private By two = By.cssSelector("[id='login-form'] > p:last-child");
    private By three = By.cssSelector("body > *:nth-child(3)");
    private By four = By.cssSelector("div.footer__menuList > a ~ * ");

    @Test
    public void testOne (){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(one);
    }
    @Test
    public void testTwo (){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(two);
    }

    @Test
    public void testThree (){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(three);
    }
    @Test
    public void testFour (){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(four);
    }


}
