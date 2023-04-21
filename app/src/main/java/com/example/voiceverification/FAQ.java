package com.example.voiceverification;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQ extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
    ExpandableListView expandableListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_faq);

        expandableListView = findViewById(R.id.exp_lst_about);

        initialze();

        ExpandableListViewAdaptor viewAdaptor = new ExpandableListViewAdaptor(FAQ.this,listDataHeader,listHashMap);
        expandableListView.setAdapter(viewAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_FAQ:
                break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_Help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return false;
    }

    public void initialze()
    {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("What is this app?");
        listDataHeader.add("What is Crowd Sourcing?");
        listDataHeader.add("What data is being stored by the app?");
        listDataHeader.add("");
//        listDataHeader.add("What is Aparoksha?");

        List<String> ans1 = new ArrayList<>();
        ans1.add("This app is meant to integrate crowd sourcing into the pipeline wherein a user commands an AI Assistant. THe Crowd sourcing is performed using Toloka");
        listHashMap.put(listDataHeader.get(0),ans1);
        List<String> ans2 = new ArrayList<>();
        ans2.add("It is the practice of obtaining information or input into a task or project by enlisting the services of a large number of people, either paid or unpaid, typically via the internet.");

        List<String> ans3 = new ArrayList<>();
        ans3.add("The only data the we store is your username, password and country. You can download the data we store and have a review for yourself");

//        List<String> ans4 = new ArrayList<>();
//        ans4.add("Yogesh Sasini");
//        ans4.add("Mallakhamb Artist India");
//        ans4.add("Lt. Col. Pankajashan K");
//        ans4.add("Neeraj Narayanan");
//        ans4.add("Yugm");

//        List<String> ans5 = new ArrayList<>();
//        ans5.add("Aparoksha is the Annual Technical Festival of IIIT Allahabad (A Centre of Excellence in Information Technology established by Ministry of HRD, Govt. of India).\n" +
//                "\n" +
//                "A collaboration of, for and by tech enthusiasts, Aparoksha is a platform for technocrats to code, design and build innovative solutions to transform India into a digitally empowered society and a knowledge based economy, all while providing a venue for self-expression and creativity.");



        listHashMap.put(listDataHeader.get(1),ans2);
        listHashMap.put(listDataHeader.get(2),ans3);
//        listHashMap.put(listDataHeader.get(3),ans4);
//        listHashMap.put(listDataHeader.get(4),ans5);
    }

}