package com.example.voiceverification;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssistantActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    TextView speechResults;
    ImageButton voiceButton;
    ListView superListView;
    JsonObject poolConfigJson;
    JsonObject taskDetails;
    String taskId;
    final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant);
        voiceButton = findViewById(R.id.voiceButton);
        speechResults = findViewById(R.id.textView2);
        voiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();

            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        superListView = findViewById(R.id.superListView);

        poolConfigJson = new JsonObject();
        taskDetails = new JsonObject();
        taskId = "";
//        getSuperHeroes();

    }

    private void speak() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                "com.domain.app");

        SpeechRecognizer recognizer = SpeechRecognizer
                .createSpeechRecognizer(this.getApplicationContext());
        RecognitionListener listener = new RecognitionListener() {
            @Override
            public void onResults(Bundle results) {
                ArrayList<String> voiceResults = results
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (voiceResults == null) {
                    System.out.println("No voice results");
                } else {
                    Log.i("Processing", "Printing matches: ");
                    for (String match : voiceResults) {
//                        System.out.println(match);
                        Log.i("Results", match);
                    }
                }
            }

            @Override
            public void onReadyForSpeech(Bundle params) {
//                System.out.println("Ready for speech");
                Log.i("Status", "Ready for speech");
            }

            /**
             *  ERROR_NETWORK_TIMEOUT = 1;
             *  ERROR_NETWORK = 2;
             *  ERROR_AUDIO = 3;
             *  ERROR_SERVER = 4;
             *  ERROR_CLIENT = 5;
             *  ERROR_SPEECH_TIMEOUT = 6;
             *  ERROR_NO_MATCH = 7;
             *  ERROR_RECOGNIZER_BUSY = 8;
             *  ERROR_INSUFFICIENT_PERMISSIONS = 9;
             *
             * @param error code is defined in SpeechRecognizer
             */
            @Override
            public void onError(int error) {
                System.err.println("Error listening for speech: " + error);
            }

            @Override
            public void onBeginningOfSpeech() {
                System.out.println("Speech starting");
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onEndOfSpeech() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onRmsChanged(float rmsdB) {
                // TODO Auto-generated method stub

            }
        };
        recognizer.setRecognitionListener(listener);
        recognizer.startListening(intent);


//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What would you want me to do today?");
////        intent.putExtra("android.speech.extra.GET_AUDIO_FORMAT", "audio/AMR");
////        intent.putExtra("android.speech.extra.GET_AUDIO", true);
//
//        try {
//            //Shows the dialog box
//            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
//        } catch (Exception e) {
//            Toast.makeText( this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && null!= data){
                    // Get the text from the voice intent
                    ArrayList <String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // Displaying the result on the TextView
                    String input = result.get(0);
                    speechResults.setText(input);

                    Log.i("Pre Pool Id", taskId);
                    String postedTaskId = "00022f999b--638b7e4f6802550c5df5cff1";
//                    postedTaskId = postTask(input);
                    Log.i("Posted Task Id", postedTaskId);

//                    if (!taskId.equals("")){
//
//                    } else{
//                        Toast.makeText(getApplicationContext(), "Task was not successfully created", Toast.LENGTH_LONG).show();
//                    }
//                    getTaskResults(postedTaskId);
//                    ArrayList<String> answers = getTaskResults(postedTaskId);

//                    String finalPostedTaskId = postedTaskId;


//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            ArrayList<String> answers = getTaskResults(finalPostedTaskId);
////                            ArrayList<String> answers = getTaskResults("00022f999b--638b7e4f6802550c5df5cff1");
//                            Log.i("List of Answers", answers.toString());
//                            superListView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, answers));
//                        }
//                    }, 70000);

//                    new CountDownTimer(70000, 20000) {
//                        public void onFinish() {
//                            ArrayList<String> answers = getTaskResults(finalPostedTaskId);
////                            ArrayList<String> answers = getTaskResults("00022f999b--638b7e4f6802550c5df5cff1");
//                            Log.i("List of Answers", answers.toString());
//                            superListView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, answers));
//                        }
//
//                        public void onTick(long millisUntilFinished) {
////                            if (millisUntilFinished == 30000){
//                                Toast.makeText(getApplicationContext(), "Please wait as we fetch the results", Toast.LENGTH_LONG).show();
////                            }
//                        }
//                    }.start();

                    // Getting the audio
                    Uri audioUri = data.getData();

                    StringBuilder stringBuilder = new StringBuilder("action: ")
                            .append(data.getAction())
                            .append(" data: ")
                            .append(data.getDataString())
                            .append(" extras: ")
                            ;
                    for (String key : data.getExtras().keySet()){
                        Log.i("Key",  key);
                        Log.i("Value",  data.getExtras().get(key).toString());
//                        stringBuilder.append(key).append("=").append(data.getExtras().get(key)).append(" ");
                    }


//                    Log.i("Data",  stringBuilder.toString());
//                    ContentResolver contentResolver = getContentResolver();
//                    try {
//                        InputStream filestream = contentResolver.openInputStream(audioUri);
////                        Toast.makeText( this, "audio" + "uri= "+ audioUri, Toast.LENGTH_LONG).show();
//                        Log.i("audio uri=", audioUri.toString());
//                    } catch (FileNotFoundException e) {
//                        Toast.makeText( this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                     TODO: read audio file from inputstream

                }
                break;
            }
        }

    }

    private String postTask(String input) {
        JsonObject taskDetails = new JsonObject();
        String taskId = "";

        taskDetails.addProperty("pool_id", "36673947");
        taskDetails.addProperty("overlap", 3);

        String json = "{\n" +
                "    \"headline\": \"" + input + "\"\n" +
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


//        call.enqueue(new Callback<TaskCreationResults>() {
//            @Override
//            public void onResponse(Call<TaskCreationResults>call, Response<TaskCreationResults> response) {
//                Log.i("Err0", response.body().toString());
//                TaskCreationResults myheroList = ;
//                Log.i("Err", String.valueOf(myheroList));
//
//
//                taskId = myheroList.getId();
//
////                String[] oneHeroes = new String[myheroList.size()];
////                Log.i("Pool Id", myheroList.get(0).getId());
//
//            }
//
//            @Override
//            public void onFailure(Call<TaskCreationResults> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
////                Log.i("Err", call[0].toString());
//            }
//
//        });

        return taskId;
    }

    private ArrayList<String> getTaskResults(String taskId) {
//        Log.i("Tag", "Getting Task Results");
        ArrayList<String> arrayOfAnswers = new ArrayList<>();
        try
        {
            GetTaskResultsAPI api = RetrofitClientResults.getInstance().getTaskResultApi();
            Log.i("APi Value", api.toString());
            Call<TaskResults> call = api.getResults(36673947);
            Response<TaskResults> response = call.execute();
//            taskResults = response.body().get(0).getAnswer();
            String currentTask = "";
            for (JsonElement e :  response.body().getresults()) {

                for(Map.Entry<String, JsonElement> entry : e.getAsJsonObject().entrySet()) {
                    if (entry.getKey().equals("tasks")){
                        Log.i("Key = ", entry.getKey());
//                        Log.i("Is Array", String.valueOf(entry.getValue().isJsonArray())); // TRUE
//                        Log.i("Is Object", String.valueOf(entry.getValue().isJsonObject()));
                        entry.getValue().getAsJsonArray().get(0).getAsJsonObject().get("id");
                        Log.i("Task Id", entry.getValue().getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString());
                        currentTask = entry.getValue().getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
                    }
                    if (entry.getKey().equals("solutions")){
                        if (currentTask.equals(taskId)){
                            Log.i("Answer", entry.getValue().getAsJsonArray().get(0).getAsJsonObject().get("output_values").getAsJsonObject().get("result").getAsString());
                            arrayOfAnswers.add(entry.getValue().getAsJsonArray().get(0).getAsJsonObject().get("output_values").getAsJsonObject().get("result").getAsString());
                        }

                    }
                }
            }
//            return taskId;
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return arrayOfAnswers;
    }





    private void getSuperHeroes() {
//        poolConfigJson = getPoolConfigjson(121958);
//        Log.i("Display", poolConfigJson.toString());
//        Call<List<PoolResults>> call = RetrofitClient.getInstance().getPostApi().sendPool(poolConfigJson);
        Call<List<Results>> call = RetrofitClient.getInstance("test").getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                    List<Results> myheroList = response.body();
                    Log.i("Err", response.body().toString());
                    Log.i("Err2", String.valueOf(myheroList));
                    String[] oneHeroes = new String[myheroList.size()];
                    Log.i("Pool Id", myheroList.get(0).getName());
//                    for (int i = 0; i < myheroList.size(); i++) {
//                        oneHeroes[i] = myheroList.get(i).getName();
//                    }
//
//                    superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));

            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
//                Log.i("Err", call[0].toString());
            }

        });
    }

    private JsonObject getPoolConfigjson(int pid) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("project_id", pid);
        jsonObject.addProperty("private_name", "Text Correction Pool 1");
        jsonObject.addProperty("may_contain_adult_content", true);
//        jsonObject.addProperty("will_expire", "<close date>");
        jsonObject.addProperty("reward_per_assignment", 0.02);
        jsonObject.addProperty("assignment_max_duration_seconds", 60);
        jsonObject.addProperty("project_id", pid);

        String json = "{\n" +
                "    \"and\": [\n" +
                "      {\n" +
                "        \"or\": [\n" +
                "          {\n" +
                "            \"category\": \"profile\",\n" +
                "            \"key\": \"languages\",\n" +
                "            \"operator\": \"IN\",\n" +
                "            \"value\": \"EN\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        JsonObject filterConfig = new Gson().fromJson(json, JsonObject.class);
        jsonObject.add("filter", filterConfig);

        json = "{\n" +
                "    \"captcha_frequency\": \"LOW\",\n" +
                "    \"configs\": [\n" +
                "      {\n" +
                "        \"collector_config\": {\n" +
                "          \"type\": \"CAPTCHA\",\n" +
                "          \"parameters\": {\n" +
                "            \"history_size\": 10\n" +
                "          }\n" +
                "        },\n" +
                "        \"rules\": [\n" +
                "          {\n" +
                "            \"conditions\": [\n" +
                "              {\n" +
                "                \"key\": \"stored_results_count\",\n" +
                "                \"operator\": \"EQ\",\n" +
                "                \"value\": 10\n" +
                "              },\n" +
                "              {\n" +
                "                \"key\": \"success_rate\",\n" +
                "                \"operator\": \"LTE\",\n" +
                "                \"value\": 70\n" +
                "              }\n" +
                "            ],\n" +
                "            \"action\": {\n" +
                "              \"type\": \"RESTRICTION_V2\",\n" +
                "              \"parameters\": {\n" +
                "                \"scope\": \"PROJECT\",\n" +
                "                \"duration_unit\": \"DAYS\",\n" +
                "                \"duration\": 3,\n" +
                "                \"private_comment\": \"Incorrect captcha input\"\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        JsonObject qualityConfig = new Gson().fromJson(json, JsonObject.class);
        jsonObject.add("quality_control", qualityConfig);

        json = "{\n" +
                "    \"real_tasks_count\": 3,\n" +
                "    \"golden_tasks_count\": 0,\n" +
                "    \"training_tasks_count\": 0\n" +
                "  }";

        JsonObject mixerConfig = new Gson().fromJson(json, JsonObject.class);
        jsonObject.add("mixer_config", mixerConfig);

        json = "{\n" +
                "    \"default_overlap_for_new_task_suites\": 3\n" +
                "  }";

        JsonObject defaultsConfig = new Gson().fromJson(json, JsonObject.class);
        jsonObject.add("defaults", defaultsConfig);

        return jsonObject;
    }


}