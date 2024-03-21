package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private static int nextTaskId = 1_000_001;
    private int taskId;
    private int workerId;
    public String taskHeading;
    public String taskText;
    private static List<Task> allTasks = new ArrayList<>();

    public Task(int workerId, String taskHeading, String taskText) {
        this.taskId = nextTaskId++;
        this.workerId = workerId;
        this.taskHeading = taskHeading;
        this.taskText = taskText;
        allTasks.add(this);
    }
    public Task(String taskHeading, String taskText) {
        this.workerId = 0;
        this.taskId = nextTaskId++;
        //this.workerId = workerId;
        this.taskHeading = taskHeading;
        this.taskText = taskText;
        allTasks.add(this);
    }


    public int getTaskId() {
        return taskId;
    }


    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getTaskHeading() {
        return taskHeading;
    }

    public void setTaskHeading(String taskHeading) {
        this.taskHeading = taskHeading;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public static List<Task> getAllTasks() {
        return allTasks;
    }

    public static void printAllTasks (List<Task> allTasks) {
        for (Task task : allTasks) {
            System.out.println(task);
        }
    }
    private String taskStatus() {
        String s = "";
        if (workerId == 0) {
            s = "the task is free";
        } else if (workerId == -1) {
            s = "the task is closed";
        } else if (workerId > 0) {
            if (workerId <= Manager.FINISH_ID) {
                s = "Task at work (manager)";
            } else {
                s = "Task at work (worker)";
            }
        } else {
            s = "ERROR";
        }
        return s;
    }


    @Override
    public String toString() {
        return "ID задачи: " + taskId +
                ", ID исполнителя: " + workerId +
                ", Заголовок задачи: " + taskHeading + '\'' +
                ", Задача: " + taskText + '\'' +
                ", Статус: " + taskStatus();
    }
}
