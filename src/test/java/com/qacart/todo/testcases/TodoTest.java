package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.objects.Task;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.TaskUtils;
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
@Feature("ToDo Feature")
public class TodoTest extends BaseTest {
//    private WebDriver driver;
//    (enabled = false)
    @Story("ADD ToDo")
    @Description("It Will ADD New ToDo Task and navigate to ToDo Page")
    @Test(description = "Should Be Able To ADD a New ToDo Correctly")
    public void ShouldBeAbleToAddNewToDo() throws InterruptedException, IOException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.manage().window().maximize();
//        driver = new DriverFactory().InitializeDriver();

//        LoginPage loginPage = new LoginPage(driver);

//        driver.get("http://qacart-todo.herokuapp.com");
//        loginPage.load();
        RegisterApi registerApi = new RegisterApi();
        registerApi.Register();

        NewToDoPage newToDoPage = new NewToDoPage(getDriver());
        newToDoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        newToDoPage.load();
//        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("isa@yahoo.com");
//        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Isa123!");
//        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

//        loginPage.Login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());

//        ToDoPage toDoPage = new ToDoPage(driver);

//        toDoPage.ClickOnPlusButton();

//        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();

//        NewToDoPage newToDoPage = new NewToDoPage(driver);
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        String actualResult = newToDoPage.AddNewTask(tasksApi.getItem())

// *************************** this in new to do page ***************************
//        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Java");
//        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();

//        String actualResult = toDoPage.GetToDoText();
        .GetToDoText();
        Assert.assertEquals(actualResult,tasksApi.getItem());



//        driver.quit();
    }
    @Story("Delete ToDo")
    @Description("It Will Delete Task")
    @Test(description = "Should Be Able To Delete a ToDo Correctly")
    public void ShouldBeAbleToDeleteTodo() throws IOException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.manage().window().maximize();

//        driver = new DriverFactory().InitializeDriver();
//    LoginPage loginPage = new LoginPage(driver);

//        driver.get("http://qacart-todo.herokuapp.com");
//    boolean actualResult = loginPage.load()
//        loginPage.load();
//        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("isa@yahoo.com");
//        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Isa123!");
//        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

//        loginPage.Login("isajudeh@yahoo.com", "Isajudeh1!");
//    .Login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//        ToDoPage toDoPage = new ToDoPage(driver);
//    .ClickOnPlusButton()
//        toDoPage.ClickOnPlusButton();

//
//        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();

//        NewToDoPage newToDoPage = new NewToDoPage(driver);
//    .AddNewTask("Learn Java")
//        newToDoPage.AddNewTask("Learn Java");
//        *************************** New To Do Page ******************************
//        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Java");
//        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();

    RegisterApi registerApi = new RegisterApi();
    registerApi.Register();
    ToDoPage toDoPage = new ToDoPage(getDriver());
    toDoPage.load();
    injectCookiesToBrowser(registerApi.getRestAssuredCookies());

    TasksApi tasksApi = new TasksApi();
    tasksApi.addTask(registerApi.getAccessToken());
    boolean actualResult =
            toDoPage
                    .load()
                    .ClickOnDeleteButton()

//        toDoPage.ClickOnDeleteButton();
//        driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
//        boolean actualResult = toDoPage.IsNoToDosMessageDisplayed();
    .IsNoToDosMessageDisplayed();

        Assert.assertTrue(actualResult);

//        driver.quit();
    }
}
