package com.example.voiceverification;

import com.google.gson.annotations.SerializedName;

public class TaskCreationResults {

    @SerializedName("id")
    private String taskid;


    public TaskCreationResults(String name) {
        this.taskid = name;
    }

    public String getId() {
        return taskid;
    }


}
