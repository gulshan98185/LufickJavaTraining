package com.lufick.training.callback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lufick.training.MyItem;
import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<ItemList> fastAdapter;
    ItemAdapter<ItemList> itemItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button button = findViewById(R.id.btn);

        recyclerView = findViewById(R.id.first_activity_recyclerView);
        itemItemAdapter = ItemAdapter.items();
        fastAdapter =  FastAdapter.with(itemItemAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fastAdapter);

        List<ItemList> listOfItems = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            int finalI = i;
            listOfItems.add(new ItemList("Title " + (i + 1), "Subtitle " + (i + 1), new ItemCallback() {
                @Override
                public void clickParent() {
                    clickParentItem(finalI);
                }

                @Override
                public void clickIcon() {
                    clickIconItem(finalI);
                }

                @Override
                public void clickSomething() {
                    super.clickSomething();
                    if(finalI!=1) {
                        clickSomethingItem(finalI);
                    }
                }
            }));
        }
        listOfItems.add(new ItemList("Title " + 6, "Subtitle " + 6, new ItemCallback() {
            @Override
            public void clickParent() {

            }

            @Override
            public void clickIcon() {

            }

        }));
        itemItemAdapter.setNewList(listOfItems);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    void clickParentItem(int position){
        Toast.makeText(this, "Parent is clicked at position "+position, Toast.LENGTH_SHORT).show();
    }
    void clickIconItem(int position){
        Toast.makeText(this, "Icon is clicked at position "+position, Toast.LENGTH_SHORT).show();
    }
    void clickSomethingItem(int position){
        Toast.makeText(this, "Something is clicked at position "+position, Toast.LENGTH_SHORT).show();
    }
}