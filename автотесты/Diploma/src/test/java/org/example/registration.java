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

public class registration {

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

    // Негативный сценарий регистрации
    @Test
    public void negativeRegistration (){
        driver.navigate().to("http://intershop5.skillbox.ru/");

        // Вход
         var buttonEnter = By.cssSelector("div a.account");
         var registration = By.cssSelector(".custom-register-button");
        driver.findElement(buttonEnter).click();
        driver.findElement(registration).click();

        // Регистрация
         var namePerson = By.cssSelector("#reg_username");
         var emailPerson = By.cssSelector("#reg_email");
         var passwordPerson = By.cssSelector("#reg_password");
         var registrationButton = By.cssSelector(".woocommerce-form-register__submit");
        driver.findElement(namePerson).sendKeys("Volodya");
        driver.findElement(emailPerson).sendKeys("test@test.ru");
        driver.findElement(passwordPerson).sendKeys("testtest");
        driver.findElement(registrationButton).click();

        //Проверка
        var textMassage = By.cssSelector(".showlogin");
        var findtext = driver.findElement(textMassage).getText();
        Assert.assertEquals("Пожалуйста авторизуйтесь.", findtext);
    }


    // Позитивный сценарий регистрации
    @Test
    public void positiveRegistration (){
        driver.navigate().to("http://intershop5.skillbox.ru/");

        // Вход
        var buttonEnter = By.cssSelector("div a.account");
        var registration = By.cssSelector(".custom-register-button");
        driver.findElement(buttonEnter).click();
        driver.findElement(registration).click();

        // Регистрация
        var namePerson = By.cssSelector("#reg_username");
        var emailPerson = By.cssSelector("#reg_email");
        var passwordPerson = By.cssSelector("#reg_password");
        var registrationButton = By.cssSelector(".woocommerce-form-register__submit");
        driver.findElement(namePerson).sendKeys("Volodya");
        driver.findElement(emailPerson).sendKeys("testtest@testtest.ru");
        driver.findElement(passwordPerson).sendKeys("testtest");
        driver.findElement(registrationButton).click();

        //Проверка
        var textMassage = By.cssSelector(".content-page");
        var findtext = driver.findElement(textMassage).getText();
        Assert.assertEquals("Регистрация завершена.", findtext);
    }

    // Позитивный сценарий входа в аккаунт
    @Test
    public void enterInResource (){
        driver.navigate().to("http://intershop5.skillbox.ru/");

        // Вход
        var buttonEnter = By.cssSelector("div a.account");
        driver.findElement(buttonEnter).click();

        // Регистрация
        var namePerson = By.cssSelector("#username");
        var passwordPerson = By.cssSelector("#password");
        var buttonEnterAccount = By.linkText("Войти");

        driver.findElement(namePerson).sendKeys("Volodya");
        driver.findElement(passwordPerson).sendKeys("testtest");
        driver.findElement(buttonEnterAccount).click();

        //Проверка
        var textMassage = By.cssSelector(".post-title");
        var findtext = driver.findElement(textMassage).getText();
        Assert.assertEquals("Мой аккаунт", findtext);
    }
}
