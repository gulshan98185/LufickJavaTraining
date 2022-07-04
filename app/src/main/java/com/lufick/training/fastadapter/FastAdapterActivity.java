package com.lufick.training.fastadapter;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public class FastAdapterActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<AbstractItem> fastAdapter;
    ItemAdapter<AbstractItem> itemAdapter;
    List<AbstractItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_adapter);
        recyclerView = findViewById(R.id.recycler_view);
        itemAdapter = new ItemAdapter<>();
        fastAdapter = FastAdapter.with(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastAdapter);

        fastAdapter.withOnClickListener((v, adapter, item, position) -> {
            if (item instanceof ListItem) {
                switch (((ListItem) item).data){
                    case BUS:
                        Toast.makeText(FastAdapterActivity.this, "BUS is running", Toast.LENGTH_SHORT).show();
                        break;
                    case CAR:
                        Toast.makeText(FastAdapterActivity.this, "CAR is running", Toast.LENGTH_SHORT).show();
                        break;
                    case NEERAJ:
                        Toast.makeText(FastAdapterActivity.this, "NEERAJ is running", Toast.LENGTH_SHORT).show();
                        break;
                    case TARUN:
                        Toast.makeText(FastAdapterActivity.this, "TARUN is running", Toast.LENGTH_SHORT).show();
                        break;
                    case DUPLICATE_NEERAJ:
                        Toast.makeText(FastAdapterActivity.this, "Duplicate is running", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            return false;
        });

        itemList = new ArrayList<>();
//        itemList.add(new HeaderItem("This is 1st header"));
//        itemList.add(new ListItem(NEERAJ));
//        itemList.add(new ListItem(TARUN));
//        itemList.add(new ListItem(SHUBHAM));
//        itemList.add(new ListItem(ABAC));
//        itemList.add(new ListItem(CAR));
//        itemList.add(new ListItem(BUS));
//        itemList.add(new ListItem(DUPLICATE_NEERAJ));
//        itemList.add(new HeaderItem("This is 2nd header"));
//        itemList.add(new ListItem(CYCLE));
//        itemList.add(new ListItem(MEDICINE));
//        itemList.add(new ListItem(MILK));
//        itemList.add(new ListItem(RAJ));
//        itemList.add(new HeaderItem("This is third header"));
//        itemList.add(new ListItem(SIX));
//        itemList.add(new ListItem(RAHUL));
//        itemList.add(new ListItem(BIKE));
//        itemList.add(new HeaderItem("This is 4th header"));
//        itemList.add(new HeaderItem("This is 5th header"));

        for (DATA data : DATA.values()){
//            itemList.add(new ListItem(data));
        }

        itemAdapter.setNewList(itemList);
    }
}