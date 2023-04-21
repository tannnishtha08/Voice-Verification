package com.example.voiceverification;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Response;

public class SendActivity extends AppCompatActivity {

    ProgressBar nDialog;
    String audioUrl;
    String postedTaskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent data = getIntent();
        postedTaskId = "0002302ec1--639370cae52ece5c621c3867";
        audioUrl = data.getStringExtra("URL");
        nDialog = findViewById(R.id.progressBar);
        nDialog.setIndeterminate(true);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        postedTaskId = postTask(audioUrl);

        Log.i("Posted Task Id", postedTaskId);

        new CountDownTimer(70000, 70000) {
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "The Results are ready!", Toast.LENGTH_LONG).show();
                Intent results = new Intent(getApplicationContext(), ResultActivity.class);
                results.putExtra("taskId", postedTaskId);
                startActivity(results);
            }
            public void onTick(long millisUntilFinished) {
//                Toast.makeText(getApplicationContext(), "The Results are ready!", Toast.LENGTH_LONG).show();

            }
        }.start();
    }

    private String postTask(String input) {
        JsonObject taskDetails = new JsonObject();
        String taskId = "";

        taskDetails.addProperty("pool_id", "36712129");
        taskDetails.addProperty("overlap", 5);

        String json = "{\n" +
                "    \"audio\": \"" + input + "\"\n" +
                "    }";

        JsonObject inputDetails = new Gson().fromJson(json, JsonObject.class);
        taskDetails.add("input_values", inputDetails);

        Log.i("Display", taskDetails.toString());

        try
        {
            Call<TaskCreationResults> call = RetrofitClient.getInstance("task").getTasksApi().sendTask(taskDetails);
            Response<TaskCreationResults> response = call.execute();
            taskId = response.body().getId();
//            Log.i("Task Id", taskId);
//            return taskId;
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return taskId;
    }
}