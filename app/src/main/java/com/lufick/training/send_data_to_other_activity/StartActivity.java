package com.lufick.training.send_data_to_other_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.lufick.training.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, EndActivity.class);
                School school = new School("ABC SCHOOL", "DELHI");
                Student student = new Student("Name is xyz", "Address is abc", 21, "City is pqr", "Country is India", school);
                intent.putExtra("DATA", (Parcelable) student);
                startActivity(intent);
            }
        });
    }
}