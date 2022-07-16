package com.lufick.training.saved_instance_state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lufick.training.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityOne extends AppCompatActivity {
    TextView nameText, addressText, genderText, ageText;
    public static final String NAME_KEY = "NAME_KEY";
    public static final String ADDRESS_KEY = "ADDRESS_KEY";
    public static final String GENDER_KEY = "GENDER_KEY";
    public static final String AGE_KEY = "AGE_KEY";
    public static final String SCHOOL_KEY = "SCHOOL_KEY";
    String name;
    ArrayList<String> address;
    boolean gender;
    int age;
    School school;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        nameText = findViewById(R.id.name);
        addressText = findViewById(R.id.address);
        genderText = findViewById(R.id.gender);
        ageText = findViewById(R.id.age);
        // data types
        /*name = "Name";
        address = new ArrayList<>();
        address.add("ADDRESS");
        gender = false;
        age = 20;
        if (savedInstanceState!=null){
            name = savedInstanceState.getString(NAME_KEY);
            address = savedInstanceState.getStringArrayList(ADDRESS_KEY);
            gender = savedInstanceState.getBoolean(GENDER_KEY);
            age = savedInstanceState.getInt(AGE_KEY);
        }
        nameText.setText(name);
        addressText.setText(address.get(address.size()-1));
        genderText.setText(gender+"");
        ageText.setText(age+"");
        nameText.setOnClickListener((v)->{
            name = "Abdul";
            nameText.setText(name);
        });
        addressText.setOnClickListener((v)->{
            address.add("Tarun");
            addressText.setText(address.get(address.size()-1));
        });
        genderText.setOnClickListener((v)->{
            gender = true;
            genderText.setText(gender+"");
        });
        ageText.setOnClickListener((v)->{
            age = 25;
            ageText.setText(age+"");
        });*/

        student = new Student("Tarun", 64);
        school = new School("Name", "Address", 500, student);
        if (savedInstanceState!=null){
            school = (School) savedInstanceState.getParcelable(SCHOOL_KEY);
        }
        nameText.setText(school.name);
        addressText.setText(school.address);
        genderText.setText(school.student.name);
        nameText.setOnClickListener((v)->{
            school.name = "Children Academy";
            nameText.setText(school.name);
        });
        addressText.setOnClickListener((v)->{
            school.address = "Srinagar";
            addressText.setText(school.address);
        });
        genderText.setOnClickListener((v)->{
            school.student.name = "Abdul";
            genderText.setText(school.student.name);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //data type
        /*outState.putString(NAME_KEY, name);
        outState.putBoolean(GENDER_KEY, gender);
        outState.putInt(AGE_KEY, age);
        outState.putStringArrayList(ADDRESS_KEY, address);*/

        outState.putParcelable(SCHOOL_KEY,  school);
    }
}