package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.Task;

public class TaskUtils {

    public static Task generateRandomTask(){
        boolean isCompleted = new Faker().bool().bool();
        String item = new Faker().name().title();

        Task task = new Task(isCompleted,item);

        return task;
    }
}
