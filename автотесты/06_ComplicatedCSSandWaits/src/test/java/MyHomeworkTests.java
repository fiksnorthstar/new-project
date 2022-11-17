import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

//задание 1 a/b/c
    private By element_p = By.cssSelector("p");
    private By first_a = By.cssSelector("div > a:nth-of-type(1)");
    private By div2_a1 = By.cssSelector("selection > div:nth-of-type(2) > a:nth-of-type(1)");

// задание 2
    private By no_id = By.cssSelector(".form > .form-row > input:not(id)");
    private By teg_p = By.cssSelector("body > p[class^='form']:not[class$='error']");
    private By div = By.cssSelector("div.form-inner > p.form-row:nth-of-type()']");

// задание 3


    @Test
    public void grandTest(){

        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");

        //переход дна карточку
        var findPlan = By.className("articlePreview__link");
        driver.findElement(findPlan).click();

        //Поиск карточки справа
        var findTextPlan = By.cssSelector("div.pageArticle__articlePreview:first-child .articlePreview__title");
        wait.until(ExpectedConditions.presenceOfElementLocated(findTextPlan));

        //Поиск необходимого блока заметки
        var showResult = driver.findElement(findTextPlan).getText();
        var actualResult = "План на следующий месяц";
        Assert.assertEquals(actualResult, showResult);

        //Поиск правой карточки
        var findRightCard = By.cssSelector("div.pageArticle__articlePreview:first-child p.articlePreview__title");
        var showFindRightCard = driver.findElement(findRightCard).getText();
        var actualResultTwo = "План на следующий месяц";
        Assert.assertEquals(actualResultTwo, showFindRightCard);

        //Удаление заметки по середине
        var deleteText = By.cssSelector(".page__content.pageArticle__content div.pageArticle__buttons button:last-child");
        driver.findElement(deleteText).click();

        //Проверка удаленного элемента
        var newFindRightCard = By.cssSelector("div.pageArticle__articlePreview:first-child p.articlePreview__title");
        wait.until(ExpectedConditions.presenceOfElementLocated(newFindRightCard));
        var deleteResult = driver.findElement(newFindRightCard).getText();
        var actualResultThree = "Путешествие на Восток";
        Assert.assertEquals(actualResultThree, deleteResult);

    }
}
