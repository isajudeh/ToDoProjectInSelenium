package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ToDoPage extends BasePage {


    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement Welcome;
    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement AddButton;

    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement ToDoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement DeleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement NoToDosMessage;


    @Step
    public NewToDoPage ClickOnPlusButton() {
        AddButton.click();
        return new NewToDoPage(driver);
    }
    @Step
    public ToDoPage load () throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_END_POINT);
        return this;
    }
    @Step
    public boolean isWelcomeMessageDisplay() {
        return Welcome.isDisplayed();
    }
    @Step
    public String GetToDoText() {
        return ToDoItem.getText();
    }
    @Step
    public ToDoPage ClickOnDeleteButton() {
        DeleteButton.click();
        return this;
    }
    @Step
    public boolean IsNoToDosMessageDisplayed() {
        return NoToDosMessage.isDisplayed();
    }

}
