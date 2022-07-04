package com.lufick.training.call_back;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lufick.training.R;
import com.lufick.training.fastadapter.DATA;
import com.lufick.training.fastadapter.HeaderItem;
import com.lufick.training.fastadapter.ListItem;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements MyCallBack{
    FastAdapter<HeaderItem> fastAdapterNav;
    ItemAdapter<HeaderItem> itemAdapterNav;
    List<HeaderItem> itemListNav;

    FastAdapter<ListItem> fastAdapterFirst;
    ItemAdapter<ListItem> itemAdapterFirst;
    List<ListItem> itemListFirst;

    FastAdapter<ListItem> fastAdapterSecond;
    ItemAdapter<ListItem> itemAdapterSecond;
    List<ListItem> itemListSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button = findViewById(R.id.go_to);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(FirstActivity.this, SeconndActivity.class));
//            }
//        });
        RecyclerView recyclerViewNav = findViewById(R.id.nav_recycler_view);
        RecyclerView recyclerViewFirst = findViewById(R.id.first_recycler_view);
        RecyclerView recyclerViewSecond = findViewById(R.id.second_recycler_view);
        itemAdapterNav = new ItemAdapter<>();
        fastAdapterNav = FastAdapter.with(itemAdapterNav);
        recyclerViewNav.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        itemListNav = new ArrayList<>();
        for (DATA data : DATA.values()){
            itemListNav.add(new HeaderItem(data.name(), this));
        }
        recyclerViewNav.setAdapter(fastAdapterNav);
        itemAdapterNav.setNewList(itemListNav);


        itemAdapterFirst = new ItemAdapter<>();
        fastAdapterFirst = FastAdapter.with(itemAdapterFirst);
        recyclerViewFirst.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        itemListFirst = new ArrayList<>();
        for (DATA data : DATA.values()){
            itemListFirst.add(new ListItem(data, new CallbackUsage() {
                @Override
                public void click(int position) {
                    clickIt(position, "First");
                }

                @Override
                public void clickItem(String name) {
                    clickThisItem(name, "Second");
                }
            }));
        }
        recyclerViewFirst.setAdapter(fastAdapterFirst);
        itemAdapterFirst.setNewList(itemListFirst);



        itemAdapterSecond = new ItemAdapter<>();
        fastAdapterSecond = FastAdapter.with(itemAdapterSecond);
        recyclerViewSecond.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        itemListSecond = new ArrayList<>();
        for (DATA data : DATA.values()){
            itemListSecond.add(new ListItem(data, new CallbackUsage() {
                @Override
                public void click(int position) {
                    clickIt(position, "Second");
                }
            }));
        }
        recyclerViewSecond.setAdapter(fastAdapterSecond);
        itemAdapterSecond.setNewList(itemListSecond);
    }

    private void clickThisItem(String name, String number) {
        Toast.makeText(this, "The name of item is "+name + " is of "+number+" rv", Toast.LENGTH_SHORT).show();
    }

    private void clickIt(int position, String number) {
        Toast.makeText(this, "The item clicked is "+position +" is of "+number+" rv", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void click(int position) {
        clickIt(position, "Nav");
    }

    @Override
    public void clickItem(String name) {
        MyCallBack.super.clickItem(name);
    }
}