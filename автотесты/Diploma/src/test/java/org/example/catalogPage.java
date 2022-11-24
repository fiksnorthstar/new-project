package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class catalogPage {

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

    // Позитивный сценарий использования каталога
    @Test
    public void catalogUse (){
        // Вход
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var buttonEnter = By.cssSelector("div a.account");
        driver.findElement(buttonEnter).click();
        var namePerson = By.cssSelector("#username");
        var passwordPerson = By.cssSelector("#password");
        var buttonEnterAccount = By.linkText("Войти");
        driver.findElement(namePerson).sendKeys("Volodya");
        driver.findElement(passwordPerson).sendKeys("testtest");
        driver.findElement(buttonEnterAccount).click();

        //Проверка
        driver.findElement(By.cssSelector(".menu-item-46")).click();
        driver.findElement(By.cssSelector(".cat-item-25")).click();
        var findTelevisor = By.partialLinkText("LED телевизор LG 65NANO956NA Ultra HD 8K");
        var findElement = driver.findElement(findTelevisor).getText();
        Assert.assertEquals("LED телевизор LG 65NANO956NA Ultra HD 8K", findElement);

        var findButtonBasket = By.cssSelector("[href='?add-to-cart=79']");
        driver.findElement(findButtonBasket).click();
        driver.findElement(By.cssSelector(".added_to_cart.wc-forward")).click();

        var findProductText = By.cssSelector("th.product-name");
        var getInf = driver.findElement(findProductText).getText();
        Assert.assertEquals("ТОВАР", getInf);

    }

}
