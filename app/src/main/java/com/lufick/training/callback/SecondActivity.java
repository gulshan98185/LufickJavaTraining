package com.lufick.training.callback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FastAdapter<ItemList> fastAdapter;
    ItemAdapter<ItemList> itemItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.second_activity_recyclerView);
        itemItemAdapter = ItemAdapter.items();
        fastAdapter =  FastAdapter.with(itemItemAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fastAdapter);

        List<ItemList> listOfItems = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            int finalI = i;
            listOfItems.add(new ItemList("title " + (i + 1), "subtitle " + (i + 1), new ItemCallback() {
                @Override
                public void clickParent() {
                    clickParentItem(finalI);
                }

                @Override
                public void clickIcon() {
                    clickIconItem(finalI);
                }
            }));
        }
        itemItemAdapter.setNewList(listOfItems);
    }

    void clickParentItem(int position){
        Toast.makeText(this, "parent is clicked at position "+position, Toast.LENGTH_SHORT).show();
    }
    void clickIconItem(int position){
        Toast.makeText(this, "icon is clicked at position "+position, Toast.LENGTH_SHORT).show();
    }
}