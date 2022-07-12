package com.lufick.training.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lufick.training.R;

public class SharedPreferenceActivity extends AppCompatActivity {
    public static final String KEY1 = "key1";
    public static final String PREFERENCE_FILE_NAME = "preference_file_name";

    public static final String REGISTER_USER = "register_user";
    public static final String USER_NAME = "username";
    public static final String PH_NO = "address";
    public static final String GENDER = "gender";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "preference_file_name";

    EditText user_name, email, gender, address, ph_no;
    Button registerBtn;

    String userDetailsStr;
//    String userName, Email , Gender, Address , PhNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        initIds();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserDetails userDetails = new UserDetails();
                userDetails.setAddress(address.getText().toString());
                userDetails.setEmail(email.getText().toString());
                userDetails.setUserName(user_name.getText().toString());
                userDetails.setGender(gender.getText().toString());
                userDetails.setPh_no(ph_no.getText().toString());

                Gson gson = new Gson();
                String userDetailsString = gson.toJson(userDetails);

             /**can use single object to send to sharedPreference in following ways*/
                storeDataInPreference(REGISTER_USER, userDetailsString);
//               storeDataInPreference(GENDER,gender.getText().toString());

                //use it to show data on same activity
                userDetailsString = getDataFromPreference(REGISTER_USER);
                UserDetails receivedUserDetails = gson.fromJson(userDetailsString, UserDetails.class);

//                Gender = getDataFromPreference(GENDER);
                showDataInLog(receivedUserDetails);
                startActivity(new Intent(SharedPreferenceActivity.this, ShowDetails.class));

            }
        });


    }

    private void showDataInLog(UserDetails receivedUserDetails) {
        Log.e("mytag", "USER NAME :  " + receivedUserDetails.getUserName());
        Log.e("mytag", "EMAIL :  " + receivedUserDetails.getEmail());
        Log.e("mytag", "ADDRESS :  " + receivedUserDetails.getAddress());
        Log.e("mytag", "GENDER :  " + receivedUserDetails.getGender());
        Log.e("mytag", "PH_NUMBER :  " + receivedUserDetails.getPh_no());
    }

    private void initIds() {
        user_name = findViewById(R.id.user_name);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.addr);
        ph_no = findViewById(R.id.ph_no);
        registerBtn = findViewById(R.id.register_btn);
    }


    //  used to get data from shared preference;;;;
    private String getDataFromPreference(String key1) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE_NAME, MODE_PRIVATE);
        if (sharedPreferences.contains(key1))
            return sharedPreferences.getString(key1, "");
        return "";
    }

    //used to store data in shared preference;;;;
    private void storeDataInPreference(String key, String value) {
        SharedPreferences.Editor sharedPreferenceEditor = getSharedPreferences(PREFERENCE_FILE_NAME, MODE_PRIVATE).edit();
//      SharedPreferences.Editor sharedPreferenceEditor = sharedPreferences.edit();
        sharedPreferenceEditor.putString(key, value);
        sharedPreferenceEditor.commit();
    }
}