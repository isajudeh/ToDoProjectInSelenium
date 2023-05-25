package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @BeforeMethod
    public void Setup() {
        WebDriver driver= new DriverFactory().InitializeDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void TearDown(ITestResult result) throws IOException {

        String testCaseName = result.getMethod().getMethodName();
        File file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File("target"+File.separator+"screenshots"+File.separator+testCaseName+".png");
        FileUtils.copyFile(file,destFile);
        InputStream inputStream = new FileInputStream(destFile);
        Allure.addAttachment("screenshot",inputStream);

        getDriver().quit();
    }

    public void injectCookiesToBrowser(List<io.restassured.http.Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> SeleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie : SeleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }

}
