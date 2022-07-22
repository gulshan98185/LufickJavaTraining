package com.lufick.training.saved_instance_state;

import static com.lufick.training.saved_instance_state.StarterActivity.DATA_ONE;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lufick.training.R;

import java.util.ArrayList;
import java.util.List;

public class EndActivity extends AppCompatActivity {
    TextView textViewName, textViewAddress, textViewStNo, textViewStName, textViewStRoll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        textViewName = findViewById(R.id.tv_name);
        textViewAddress = findViewById(R.id.tv_address);
        textViewStNo = findViewById(R.id.tv_st_no);
        textViewStName = findViewById(R.id.tv_st_name);
        textViewStRoll = findViewById(R.id.tv_st_roll_no);

        School school = (School) getIntent().getParcelableExtra(DATA_ONE);

        textViewName.setText(school.name);
        textViewAddress.setText(school.address);
        textViewStNo.setText("No of student: "+school.noOfStudent);
        textViewStName.setText("St name: "+school.student.name);
        textViewStRoll.setText("St roll no: "+school.student.rollNo);
    }

}