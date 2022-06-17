package com.lufick.training.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.lufick.training.Database.model.DeveloperDetails;
import com.lufick.training.Database.model.Mislaneous;
import com.lufick.training.R;

import java.util.ArrayList;

public class DevelopersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Log.d("myTag", "Developers onCreate called");
        DatabaseHelper databaseHelper = new DatabaseHelper(DevelopersActivity.this);
        databaseHelper.getWritableDatabase();
//        Log.d("myTag", "onCreate ends ");

        DeveloperDetails developerDetails = new DeveloperDetails();
        developerDetails.setDev_name("Neeraj");
        developerDetails.setDev_exp(1);
        developerDetails.setDev_skill("JAVA");


        developerDetails.setMislaneous(getMislaneousJsonString());


        databaseHelper.insertData(developerDetails);

        Log.d("myTag", "data inserted ");
        ArrayList<DeveloperDetails> developerDetailsArrayList = databaseHelper.getAllDevelopers();
        for (DeveloperDetails developers:developerDetailsArrayList) {
            Log.d("myTag", "developers id :" +developers.getDev_id());
            Log.d("myTag", "developers name :" +developers.getDev_name());
            Log.d("myTag", "developers skill :" +developers.getDev_skill());
            Mislaneous mislaneous = getMislaneouObjectFromString(developers.getMislaneous());
            Log.d("myTag", "mislaneous dev height: "+mislaneous.dev_height);
            Log.d("myTag", "mislaneous dev weight: "+mislaneous.dev_weight);
            Log.d("myTag", "mislaneous dev place: "+mislaneous.place);
            Log.d("myTag", "developers exp :" +developers.getDev_exp());
        }

        DeveloperDetails developerDetails1 = new DeveloperDetails();
        developerDetails1.setDev_id(2);
        developerDetails1.setDev_name("Aashish");
        developerDetails1.setDev_skill("C++");
        developerDetails1.setDev_exp(2);

        databaseHelper.updateById(developerDetails1);
//        Log.d("myTag", "update occured : "+ rowsAffected);
    }

    private Mislaneous getMislaneouObjectFromString(String mislaneous) {
        Gson gson = new Gson();
        return gson.fromJson(mislaneous,Mislaneous.class);
    }

    private String getMislaneousJsonString() {
        Gson gson = new Gson();
        Mislaneous mislaneous = new Mislaneous();
        mislaneous.dev_height = 175;
        mislaneous.dev_weight = 65;
        mislaneous.place ="Delhi";
        return gson.toJson(mislaneous,Mislaneous.class);
    }
}