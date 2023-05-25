package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userID;
    private String firstName;

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void setRestAssuredCookies(List<Cookie> restAssuredCookies) {
        this.restAssuredCookies = restAssuredCookies;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void Register() throws IOException {

        User user = new UserUtils().generateRandomUser();

        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(user)
                .when()
                        .post(EndPoint.API_REGISTER_END_POINT)
                .then()
                        .log().all()
                        .extract().response();
//        validation .....
        if (response.statusCode() != 201){
            throw new RuntimeException("SomeThing Went Wrong With Request");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");

    }
}