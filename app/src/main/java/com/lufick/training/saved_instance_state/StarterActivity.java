package com.lufick.training.saved_instance_state;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lufick.training.R;

public class StarterActivity extends AppCompatActivity {
    public static final String DATA_ONE = "DATA_ONE";

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        button = findViewById(R.id.starter_btn);


        //Sending data from one class to another
        Student student = new Student("Abdul", 1);
        School school = new School("L.C.Collage", "Lucknow", 2000, student);
        button.setOnClickListener((v)->{
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra(DATA_ONE, school);
            startActivity(intent);
        });




        // cloning object
//        Student student = new Student("Abdul", 1);
//        School school = new School("L.C.Collage", "Lucknow", 2000, student);
//
//        Gson gson = new Gson();
//        String schoolString = gson.toJson(school);
//        School school1 = gson.fromJson(schoolString, School.class);

//        School school1 = school;
//        School school1 = school.clone();

//        Log.d("TAG_NAME", "onCreate1: "+school.name);
//        school1.name = "P.G. Collage";
//        Log.d("TAG_NAME", "onCreate2: "+school1.name);
//        Log.d("TAG_NAME", "onCreate3: "+school.name);
    }
}