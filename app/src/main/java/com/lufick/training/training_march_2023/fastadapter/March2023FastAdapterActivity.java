package com.lufick.training.training_march_2023.fastadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.ArrayList;

public class March2023FastAdapterActivity extends AppCompatActivity {
    RecyclerView fastAdapterRecyclerView;
    FastAdapter<Item> fastAdapter;
    ItemAdapter<Item> itemItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_march2023_fast_adapter);
        fastAdapterRecyclerView = findViewById(R.id.fastadapter_rv);
        itemItemAdapter = new ItemAdapter<>();
        fastAdapter = FastAdapter.with(itemItemAdapter);
        fastAdapterRecyclerView.setAdapter(fastAdapter);
        fastAdapterRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Item> itemArrayList = new ArrayList<>();
        for (int i = 0; i<50; i++){
            itemArrayList.add(new Item("Item "+(i+1)));
        }

        fastAdapter.withOnClickListener(new OnClickListener<Item>() {
            @Override
            public boolean onClick(View v, IAdapter<Item> adapter, Item item, int position) {
                Toast.makeText(March2023FastAdapterActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        itemItemAdapter.setNewList(itemArrayList);
    }
}