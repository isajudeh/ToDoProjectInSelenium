package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class NewToDoPage extends BasePage {
    public NewToDoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement NewToDoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement NewToDoSubmit;
    @Step
    public NewToDoPage load () throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_END_POINT);
        return this;
    }
    @Step
    public ToDoPage AddNewTask(String learn) {
        NewToDoInput.sendKeys(learn);
        NewToDoSubmit.click();
        return new ToDoPage(driver);
    }
}
