package com.example.voiceverification;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GetTaskResultsAPI {

    String BASE_URL = "https://toloka.dev/";

    @Headers({
            "Authorization: OAuth y0_AgAAAABl2_-yAACtpQAAAADTN0zX7-gJHe7bRDmXPwmVX-Z6Pw-y12E"
    })
    @GET("api/v1/assignments")
    Call<TaskResults>  getResults(@Query("pool_id") int poolId);

}
