import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Work4 {

    @Test
    public void testHelloIgor (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");


        driver.findElement(By.name("name")).sendKeys("Ковалев Игорь Ольгович");
        driver.findElement(By.name("email")).sendKeys("skotch@kazahstan.com");
        driver.findElement(By.name("phone")).sendKeys("8-900-342-23-22");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult =  driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult =  "Здравствуйте, Ковалев Игорь Ольгович.\n" +
                "На вашу почту (skotch@kazahstan.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 8-900-342-23-22.";
        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();

    }

    @Test
    public void testNullName (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");


        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("skotch@kazahstan.com");
        driver.findElement(By.name("phone")).sendKeys("8-900-342-23-22");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult =  driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult =  "Здравствуйте, .\n" +
                "На вашу почту (skotch@kazahstan.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 8-900-342-23-22.";
        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();

    }

}
