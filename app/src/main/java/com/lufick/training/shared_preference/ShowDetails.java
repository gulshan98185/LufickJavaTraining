package com.lufick.training.shared_preference;

import static com.lufick.training.shared_preference.SharedPreferenceActivity.PREFERENCE_FILE_NAME;
import static com.lufick.training.shared_preference.SharedPreferenceActivity.REGISTER_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lufick.training.R;

public class ShowDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        TextView userDetailsTv = findViewById(R.id.user_details);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE_NAME,MODE_PRIVATE);
               String userDetailsStr =  sharedPreferences.getString(REGISTER_USER,"");
               Gson gson = new Gson();
               UserDetails userDetails = gson.fromJson(userDetailsStr,UserDetails.class);
               userDetailsTv.setText(getUserStringFromObj(userDetails));


    }

    private String getUserStringFromObj(UserDetails userDetails) {
        return  "Name : "+userDetails.getUserName()+"\n"+"Gender : "+userDetails.getGender()+
                "\n"+"Phone No. : "+userDetails.getPh_no()+"\n"+"Address : "+userDetails.getAddress()+"\n"+
                "EMAIL : "+userDetails.getEmail();
    }
}