package com.qacart.todo.utils;

import com.qacart.todo.api.RegisterApi;
import io.restassured.http.Cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
//    this method just to convert rest-assured-cookies to selenium-cookies
    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies) {

        List<org.openqa.selenium.Cookie> SeleniumCookies = new ArrayList<>();
        for (Cookie cookie: restAssuredCookies){
            org.openqa.selenium.Cookie SeleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            SeleniumCookies.add(SeleniumCookie);
        }

        return SeleniumCookies;
    }

}