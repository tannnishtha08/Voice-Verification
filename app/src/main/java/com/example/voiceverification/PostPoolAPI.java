package com.example.voiceverification;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostPoolAPI {

    String BASE_URL = "https://sandbox.toloka.dev/";

    @Headers({
            "Authorization: OAuth y0_AgAAAABl2_-yAACtpQAAAADTN0zX7-gJHe7bRDmXPwmVX-Z6Pw-y12E",
            "Content-Type: application/JSON"
    })
    @POST("api/v1/pools")
    Call<PoolResults> sendPool(@Body JsonObject poolDetails);

}
