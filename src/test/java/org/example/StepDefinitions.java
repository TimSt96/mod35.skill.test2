package org.example;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefinitions {
    public static final WebDriver webDriver;
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\garre\\IdeaProjects\\chromedriver.exe");
    webDriver = new ChromeDriver();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Given("url of platform {string}")
    public void url_of_platform(String url) {
        webDriver.get(url);
    }
    @Then("enter name {string}")
    public void enter_name(String name) {
        WebElement webElement = webDriver.findElement(By.name("name"));
        webElement.sendKeys(name);
    }
    @Then("enter email {string}")
    public void enter_email(String email) {
        WebElement webElement = webDriver.findElement(By.name("email"));
        webElement.sendKeys(email);
    }
    @Then("enter phone {string}")
    public void enter_phone(String phone) {
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"form456746058\"]/div[2]/div[3]/div/div[1]/input[1]"));
        webElement.sendKeys(phone);
    }
    @And("check is corrected")
    public void check_is_corrected() {
        webDriver.findElement(By.xpath("//*[@id=\"form456746058\"]/div[2]/div[5]/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"tildaformsuccesspopup\"]/div/div")); //поиск элемента с сообщением о том что данные приняты и нам перезвонят
    }
    @And("check is incorrect")
    public void check_is_incorrect() {
        webDriver.findElement(By.xpath("//*[@id=\"form456746058\"]/div[2]/div[5]/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"tilda-popup-for-error\"]")); //поиск элемента на странице, с просьбой о корректного указания имени, email, телефона, означающий, что система не приняла некорректные данные в поля ввода
    }

}
