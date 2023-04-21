package com.example.voiceverification;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("transcription")
    private String superName;


    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}