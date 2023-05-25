package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
@Feature("ToDo Feature")
public class TodoTest extends BaseTest {
    @Story("ADD ToDo")
    @Description("It Will ADD New ToDo Task and navigate to ToDo Page")
    @Test(description = "Should Be Able To ADD a New ToDo Correctly")
    public void ShouldBeAbleToAddNewToDo() throws InterruptedException, IOException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.Register();
        NewToDoPage newToDoPage = new NewToDoPage(getDriver());
        newToDoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        newToDoPage.load();
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());
        String actualResult = newToDoPage.AddNewTask(tasksApi.getItem())
        .GetToDoText();
        Assert.assertEquals(actualResult,tasksApi.getItem());
    }
    @Story("Delete ToDo")
    @Description("It Will Delete Task")
    @Test(description = "Should Be Able To Delete a ToDo Correctly")
    public void ShouldBeAbleToDeleteTodo() throws IOException {
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
    .IsNoToDosMessageDisplayed();
        Assert.assertTrue(actualResult);
    }
}
