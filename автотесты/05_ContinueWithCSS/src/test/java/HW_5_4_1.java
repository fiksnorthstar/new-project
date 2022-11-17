import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_5_4_1 {

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

    private By info_about_us = By.cssSelector("[test-info='about-us']");
    private By a_href = By.cssSelector("a[href='']");
    private By option_selected = By.cssSelector("option[selected]");
    private By div_book = By.cssSelector("div[class=book-price]");
    private By button_class = By.cssSelector("button[class^='book']");
    private By class_main = By.cssSelector("[class$='main']");
    private By a_class_menu = By.cssSelector("a[class*='menu']");

    @Test
    public void testOne (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(info_about_us);
        driver.findElement(a_href);
    }
    @Test
    public void testTwo (){
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElement(option_selected);
    }
    @Test
    public void testThree (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(div_book);
    }
    @Test
    public void testFour (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(button_class);
    }
    @Test
    public void testFive (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(class_main);
    }
    @Test
    public void testSix (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(class_main);
    }
    @Test
    public void testSeven (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(a_class_menu);
    }


}
