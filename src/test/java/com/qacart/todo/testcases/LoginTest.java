package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {

//    private WebDriver driver;
    @Story("Login With Email & Password")
    @Description("It Will Login By EMAIL & PASSWORD and navigate to ToDo Page")
    @Test(description="The Login Functionality using Email & Password", enabled = false)
    public void ShouldBeAbleToLoginWithEmailAndPassword() throws IOException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.manage().window().maximize();

//        driver = new DriverFactory().InitializeDriver();
        LoginPage loginPage = new LoginPage(getDriver());

//        driver.get("http://qacart-todo.herokuapp.com");
        loginPage.load();

//        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("isa@yahoo.com");
//        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Isa123!!");
//        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

        loginPage.Login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());

        ToDoPage toDoPage = new ToDoPage(getDriver());
//        boolean actualResult = toDoPage.isWelcomeMessageDisplay();

//        boolean actualResult = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();
        Assert.assertTrue(toDoPage.isWelcomeMessageDisplay());

//        driver.quit();
    }
}
