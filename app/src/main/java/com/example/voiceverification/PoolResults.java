package com.example.voiceverification;

import com.google.gson.annotations.SerializedName;

public class PoolResults {

    @SerializedName("id")
    private String poolid;


    public PoolResults(String name) {
        this.poolid = name;
    }

    public String getId() {
        return poolid;
    }

}
