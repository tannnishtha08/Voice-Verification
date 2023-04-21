package com.example.voiceverification;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Api myApi;
    private PostPoolAPI papi;
    private PostTasksAPI tapi;

    private RetrofitClient(String type) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-
        Retrofit retrofit;
        switch (type){
            case ("test"):
                retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                myApi = retrofit.create(Api.class);
            break;
            case ("task"):
                retrofit = new Retrofit.Builder().baseUrl(PostTasksAPI.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                tapi = retrofit.create(PostTasksAPI.class);
                break;
            case ("pool"):
                retrofit = new Retrofit.Builder().baseUrl(PostPoolAPI.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                papi = retrofit.create(PostPoolAPI.class);
                break;
        }

    }

    public static synchronized RetrofitClient getInstance(String type) {
        if (instance == null) {
            instance = new RetrofitClient(type);
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }

    public PostPoolAPI getPostApi() {
        return papi;
    }

    public PostTasksAPI getTasksApi() {
        return tapi;
    }

}