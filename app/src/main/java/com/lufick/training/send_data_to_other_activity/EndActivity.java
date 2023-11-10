package com.lufick.training.send_data_to_other_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lufick.training.R;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Student student = getIntent().getParcelableExtra("DATA");
        School school = student.school;
        /*String address = getIntent().getStringExtra("DATA2");
        int age = getIntent().getIntExtra("DATA3", 0);
        String city = getIntent().getStringExtra("DATA4");
        String country = getIntent().getStringExtra("DATA5");*/
        TextView textView = findViewById(R.id.textView);
        textView.setText(student.name+"\n"+student.address+"\n"+"Age is "+student.age+"\n"+student.city+"\n"+student.country+"\n"+"School name is "+school.schoolName+"\n"+"School address is "+school.schoolAddress);
    }
}