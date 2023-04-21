package com.example.voiceverification;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class TaskResults {

    @SerializedName("items")
    private JsonArray result;


    public TaskResults(JsonArray ans) {
        this.result = ans;
    }

    public JsonArray getresults() {
        return result;
    }

}
