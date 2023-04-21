package com.example.voiceverification;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientResults {

    private static RetrofitClientResults instance = null;
    private Api myApi;
    private PostPoolAPI papi;
    private PostTasksAPI tapi;
    private GetTaskResultsAPI rapi;

    private RetrofitClientResults() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-
        Retrofit retrofit;

        retrofit = new Retrofit.Builder().baseUrl(GetTaskResultsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        rapi = retrofit.create(GetTaskResultsAPI.class);


    }

    public static synchronized RetrofitClientResults getInstance() {
        if (instance == null) {
            instance = new RetrofitClientResults();
        }
        return instance;
    }

    public GetTaskResultsAPI getTaskResultApi() {
        return rapi;
    }

}
