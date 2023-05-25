package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.TaskUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TasksApi {
    private boolean isCompleted;
    private String item;

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }




    public void addTask(String token) throws IOException {
        Task task = TaskUtils.generateRandomTask();
        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(task)
                        .auth().oauth2(token)
                .when()
                        .post(EndPoint.API_TASKS_END_POINT)
                .then()
                        .log().all()
                        .extract().response();
//        validation .....
        if (response.statusCode() != 201){
            throw new RuntimeException("SomeThing Went Wrong With Request");
        }
        isCompleted = task.getIsCompleted();
        item = task.getItem();
    }
}
