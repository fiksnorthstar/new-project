import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

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

    //Задание 1

    @Test
    public void firstTest (){
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        var buttonBack = By.xpath("//span[@class='da-arrows-prev']");
        var knowMore = By.xpath("(//a[@class='da-link button'])[2]");
        var onlyFilter = By.xpath("(//*[starts-with(@class, 'button')]");
        var subscribeButton = By.xpath("//*[text()='Подписаться сейчас']");
        var allFotoClients = By.xpath("//img[starts-with(@alt, 'client logo')]");
    }
    @Test
    public void secondTest (){
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        var header = By.xpath("//*[text()='Алфавит для взрослых (обновлённый материал)']");
        var lastElementPeriod = By.xpath("(//*[text()='7 месяцев'])[6]");
    }

    @Test
    public void thirdTest (){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var aboutUs = By.xpath("//*[@test-info='about-us']");
        var bestsellers = By.xpath("(//a[text()='Бестселлеры'])[2]");
        var search = By.xpath("//*[@id='search-input']");
        var basket = By.xpath("//*[@src='./img/shop4.png']");
        driver.findElement(basket).click();
        var total = By.xpath("//*[@id='total']");
        var youOrder = By.xpath("//div[text()='Ваш заказ: ']");
        var searchBooks = By.xpath("//*[@href='search.html']");
        driver.findElement(searchBooks).click();
        var cancellation = By.xpath("//*[text()='Отменить']");
    }

}
