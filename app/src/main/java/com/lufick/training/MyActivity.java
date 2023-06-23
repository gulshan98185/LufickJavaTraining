package com.lufick.training;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;

import java.util.ArrayList;
import java.util.List;

import bolts.Continuation;
import bolts.Task;

public class MyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<MyItem>  fastAdapter;
    ItemAdapter<MyItem>  itemItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        recyclerView = findViewById(R.id.recycler_view);
        itemItemAdapter = ItemAdapter.items();
        fastAdapter =  FastAdapter.with(itemItemAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fastAdapter);

        List<MyItem> listOfItems = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            listOfItems.add(new MyItem("List item no "+(i+1)));
        }
        itemItemAdapter.setNewList(listOfItems);

        fastAdapter.withOnClickListener(new OnClickListener<MyItem>() {
            @Override
            public boolean onClick(View v, IAdapter<MyItem> adapter, MyItem item, int position) {
                //Toast.makeText(MyActivity.this, "Clicked item is "+position + " name "+item.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        fastAdapter.withOnLongClickListener(new OnLongClickListener<MyItem>() {
            @Override
            public boolean onLongClick(View v, IAdapter<MyItem> adapter, MyItem item, int position) {
                Toast.makeText(MyActivity.this, "Clicked item is "+position + " name "+item.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}