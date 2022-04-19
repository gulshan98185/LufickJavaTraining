package com.lufick.training.call_back;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lufick.training.R;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    NavAdapter navAdapter;
    FirstRvAdapter firstRvAdapter;
    FirstRvAdapter secondRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button = findViewById(R.id.go_to);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, FirstActivity.class));
            }
        });


        RecyclerView recyclerViewNav = findViewById(R.id.nav_recycler_view);
        RecyclerView recyclerViewFirst = findViewById(R.id.first_recycler_view);
        RecyclerView recyclerViewSecond = findViewById(R.id.second_recycler_view);
        recyclerViewNav.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        List<String> listNav = new ArrayList<>();
        for (int i= 0; i<20; i++){
            listNav.add("Nav "+(i+1));
        }
        navAdapter = new NavAdapter(listNav, new MyCallBack() {
            @Override
            public String click(int position) {
                //kapde leke aao
                Toast.makeText(ThirdActivity.this, "Third Activity NavItem clicked " + (position + 1), Toast.LENGTH_SHORT).show();
                return "Clicked";
            }

            @Override
            public void clickItem(String name) {
                Log.d("Shubham", "click: Third Activity NavItem clicked " + name);
            }
        }, new MyAbstractCallBack() {
            @Override
            void doItNow() {
                Toast.makeText(ThirdActivity.this, "Do it Now", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewNav.setAdapter(navAdapter);


        recyclerViewFirst.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        List<String> listFirst = new ArrayList<>();
        for (int i= 0; i<40; i++){
            listFirst.add("First list item "+(i+1));
        }
        firstRvAdapter = new FirstRvAdapter(listFirst, new MyCallBack() {
            @Override
            public String click(int position) {
                // saman leke aao
                Toast.makeText(ThirdActivity.this, "Third Activity FirstItem clicked " + (position+1), Toast.LENGTH_SHORT).show();
                return "Clicked";
            }

            @Override
            public void clickItem(String name) {
                Log.d("Shubham", "click: Third Activity FirstItem clicked "+name);
            }
        });
        recyclerViewFirst.setAdapter(firstRvAdapter);


        recyclerViewSecond.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        List<String> listSecond = new ArrayList<>();
        for (int i= 0; i<50; i++){
            listSecond.add("Second list item "+(i+1));
        }
        secondRvAdapter = new FirstRvAdapter(listSecond, new MyCallBack() {
            @Override
            public String click(int position) {
                //chawal leke aao
                Toast.makeText(ThirdActivity.this, "Third Activity SecondItem clicked " + (position+1), Toast.LENGTH_SHORT).show();
                return "Clicked";
            }

            @Override
            public void clickItem(String name) {
                Log.d("Shubham", "click: Third Activity SecondItem clicked "+name);
            }
        });
        recyclerViewSecond.setAdapter(secondRvAdapter);
    }
}