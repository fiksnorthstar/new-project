import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {
    /* В этом классе можете описать тесты для домашнего задания */

    WebDriver driver;
    @Before
    public void startDriver (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public  void endTest (){
        driver.quit();
    }

    @Test
    public void onlineCinemaTest (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Коля");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.id("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();

        var actualResult = driver.findElement(By.className("form-result")).getText();;
        var expectedResult =  "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void emptySpace (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();

        var actualResult = driver.findElement(By.className("form-error")).getText();;
        var expectedResult =  "Введите имя";
        Assert.assertEquals(expectedResult, actualResult);
    }



}
