package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    private WebDriver driver;
//
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement InputEmail;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement InputPassword;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement Submit;
    @Step
    public LoginPage load() throws IOException {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
    @Step
    public ToDoPage Login(String email, String password) {
        InputEmail.sendKeys(email);
        InputPassword.sendKeys(password);
        Submit.click();
        return new ToDoPage(driver);
    }

}
