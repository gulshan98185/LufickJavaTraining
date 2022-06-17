package com.lufick.training.Database;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lufick.training.R;

public class BasicDatabaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_database_activity);

        Log.d("myTag", "Activity called");
        DatabaseHelper databaseHelper = new DatabaseHelper(this);



    }
}
