import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_5_4_2 {

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

    private By div_footer = By.cssSelector("footer > div");
    private By li = By.cssSelector("li > a");
    private By div = By.cssSelector("div[class='book-price'] > button");

    @Test
    public void testOne(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(div_footer);
    }
    @Test
    public void testTwo(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(li);
    }
    @Test
    public void testThree(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(div);
    }


}
