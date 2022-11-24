package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basket {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void catalogUse (){

        //Проверка
        driver.findElement(By.cssSelector(".menu-item-46")).click();
        driver.findElement(By.cssSelector(".cat-item-25")).click();
        var findTelevisor = By.partialLinkText("LED телевизор LG 65NANO956NA Ultra HD 8K");
        var findElement = driver.findElement(findTelevisor).getText();
        Assert.assertEquals("LED телевизор LG 65NANO956NA Ultra HD 8K", findElement);

        var findButtonBasket = By.cssSelector("[href='?add-to-cart=79']");
        driver.findElement(findButtonBasket).click();
        driver.findElement(By.cssSelector(".added_to_cart.wc-forward")).click();

        //Проверка добавлен ли товар
        var findProductText = By.cssSelector("th.product-name");
        var getInf = driver.findElement(findProductText).getText();
        Assert.assertEquals("ТОВАР", getInf);

        //Применение промокода
        var findPrice = By.cssSelector(".product-subtotal .woocommerce-Price-amount.amount");
        var price = driver.findElement(findPrice).getText();
        Assert.assertEquals("219990,00₽", price);

        var findCoupon = By.cssSelector("#coupon_code");
        driver.findElement(findCoupon).sendKeys("sert500");
        driver.findElement(By.cssSelector("td div button.button")).click();

        //Получение скидки
        var newMassage = driver.findElement(By.cssSelector(".cart-discount.coupon-sert500")).getText();
        Assert.assertEquals("СКИДКА: SERT500 -500,00₽ [Удалить]", newMassage);
    }

    @Test
    public void delete (){

        //Проверка
        driver.findElement(By.cssSelector(".menu-item-46")).click();
        driver.findElement(By.cssSelector(".cat-item-25")).click();
        var findTelevisor = By.partialLinkText("LED телевизор LG 65NANO956NA Ultra HD 8K");
        var findElement = driver.findElement(findTelevisor).getText();
        Assert.assertEquals("LED телевизор LG 65NANO956NA Ultra HD 8K", findElement);

        var findButtonBasket = By.cssSelector("[href='?add-to-cart=79']");
        driver.findElement(findButtonBasket).click();
        driver.findElement(By.cssSelector(".added_to_cart.wc-forward")).click();

        //Проверка удаления товара
        var findDelete = By.cssSelector("td.product-remove");
        driver.findElement(findDelete).click();

        var findDeleteInf = By.cssSelector(".cart-empty.woocommerce-info");
        var getText = driver.findElement(findDeleteInf).getText();
        Assert.assertEquals("Корзина пуста.", getText);
    }

}
