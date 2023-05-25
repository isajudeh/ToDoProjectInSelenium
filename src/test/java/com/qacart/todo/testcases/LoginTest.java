package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login With Email & Password")
    @Description("It Will Login By EMAIL & PASSWORD and navigate to ToDo Page")
    @Test(description="The Login Functionality using Email & Password", enabled = false)
    public void ShouldBeAbleToLoginWithEmailAndPassword() throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.Login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());
        ToDoPage toDoPage = new ToDoPage(getDriver());
        Assert.assertTrue(toDoPage.isWelcomeMessageDisplay());
    }
}
