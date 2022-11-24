package org.example;

import com.beust.ah.A;
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

public class ordering {



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
        var buttonEnterAccount = By.cssSelector(".woocommerce-form-login__submit");
        driver.findElement(namePerson).sendKeys("Volodya");
        driver.findElement(passwordPerson).sendKeys("testtest");
        driver.findElement(buttonEnterAccount).click();
        var enter = By.cssSelector(".post-title");
        driver.findElement(enter).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(enter));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    //Оформление товара
    @Test
    public void ordering () {

        //Добавление товара
        driver.findElement(By.cssSelector(".menu-item-46")).click();
        driver.findElement(By.cssSelector(".cat-item-25")).click();
        var findTelevisor = By.partialLinkText("LED телевизор LG 65NANO956NA Ultra HD 8K");
        var findElement = driver.findElement(findTelevisor).getText();
        Assert.assertEquals("LED телевизор LG 65NANO956NA Ultra HD 8K", findElement);

        var findButtonBasket = By.cssSelector("[href='?add-to-cart=79']");
        driver.findElement(findButtonBasket).click();
        driver.findElement(By.cssSelector(".added_to_cart.wc-forward")).click();

        //Оформление заказа
        var order = By.cssSelector(".checkout-button.button.alt.wc-forward");
        driver.findElement(order).click();

        //Проверка страници офрмления заказа
        var post_title = By.cssSelector(".post-title");
        var ordetText = driver.findElement(post_title).getText();
        Assert.assertEquals("Оформление заказа", ordetText);

        //Ввод данных
        var name = By.cssSelector("#billing_first_name");
        driver.findElement(name).sendKeys("Volodya");
        var lastName = By.cssSelector("#billing_last_name");
        driver.findElement(lastName).sendKeys("Kovalevski");
        var address = By.cssSelector("#billing_address_1");
        driver.findElement(address).sendKeys("Zemlya");
        var city = By.cssSelector("#billing_city");
        driver.findElement(city).sendKeys("Krasnoyarsk");
        var region = By.cssSelector("#billing_state");
        driver.findElement(region).sendKeys("Krasnoyarsk");
        var postcode = By.cssSelector("#billing_postcode");
        driver.findElement(postcode).sendKeys("660135");
        var billing_phone = By.cssSelector("#billing_phone");
        driver.findElement(billing_phone).sendKeys("89999999999");

        var orderButton = By.cssSelector("#place_order");
        driver.findElement(orderButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(orderButton));
        var orderEnd = By.cssSelector(".post-title");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderEnd));


        //Првоерка оформленного заказа
        var orderFinish = By.cssSelector(".woocommerce-thankyou-order-received");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderFinish));
        var textOrder = driver.findElement(orderFinish).getText();
        Assert.assertEquals("Спасибо! Ваш заказ был получен.", textOrder);


    }



}
