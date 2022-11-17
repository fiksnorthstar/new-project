import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW3_4 {


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
    public void testScoreNegative (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("50");
        driver.findElement(By.id("check-size-button")).click();

        var actualResult =  driver.findElement(By.id("size-error")).getText();
        var expectedResult =  "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("Неверное сообщение о наличии указанного размера", expectedResult, actualResult);
    }

    @Test
    public void testScore (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("40");
        driver.findElement(By.id("check-size-button")).click();

        var actualResult =  driver.findElement(By.className("error")).getText();
        var expectedResult =  "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBooksScore (){
        driver.navigate().to("http://qajava.skillbox.ru/");
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.linkText("Предзаказы"));
        driver.findElement(By.className("book-add"));
        driver.findElement(By.id("cart_count"));
        driver.findElement(By.linkText("Книги"));
        driver.findElement(By.name("search-input-form"));
    }

    @Test
    public void testBooks (){
        driver.navigate().to("http://qajava.skillbox.ru/");
        var actualResult =  driver.findElements(By.className("book-info")).size();
        Assert.assertEquals(15, actualResult);
    }

    @Test
    public void testMovies (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("films")).sendKeys("Вдребезги");
        driver.findElement(By.id("serials")).sendKeys("Атака титанов");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();

        var actualResultFilms = driver.findElement(By.id("best_films")).getText();
        var actualResultSerials = driver.findElement(By.id("best_serials")).getText();

        Assert.assertEquals("Вдребезги", actualResultFilms);
        Assert.assertEquals("Атака титанов", actualResultSerials);
    }

    @Test
    public void testMoviesNullPlace (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResultFilms = driver.findElement(By.id("best_films")).getText();
        Assert.assertEquals("", actualResultFilms);

    }

        @Test
    public void testMoviesNumber (){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("films")).sendKeys("214124");
        driver.findElement(By.id("serials")).sendKeys("124121");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();

        var actualResultFilms = driver.findElement(By.id("best_films")).getText();
        var actualResultSerials = driver.findElement(By.id("best_serials")).getText();

        Assert.assertEquals("214124", actualResultFilms);
        Assert.assertEquals("124121", actualResultSerials);

    }

}
