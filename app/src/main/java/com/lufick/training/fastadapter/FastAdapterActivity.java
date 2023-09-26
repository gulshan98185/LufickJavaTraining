package com.lufick.training.fastadapter;

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
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;

import java.util.ArrayList;
import java.util.List;

public class FastAdapterActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<Item> fastAdapter;
    ItemAdapter<Item> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_adapter);
        recyclerView = findViewById(R.id.recycler_view);
        itemAdapter = ItemAdapter.items();
        fastAdapter = FastAdapter.with(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastAdapter);
        ArrayList<Item> itemArrayList = new ArrayList<>();
        for (int i=1; i<=100; i++){
            Item item = new Item("Title "+i);
            itemArrayList.add(item);
        }

        itemAdapter.setNewList(itemArrayList);
        fastAdapter.withOnClickListener(new OnClickListener<Item>() {
            @Override
            public boolean onClick(View v, IAdapter<Item> adapter, Item item, int position) {
//                Toast.makeText(FastAdapterActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        fastAdapter.withOnLongClickListener(new OnLongClickListener<Item>() {
            @Override
            public boolean onLongClick(View v, IAdapter<Item> adapter, Item item, int position) {
                Toast.makeText(FastAdapterActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        fastAdapter.withEventHook(new ClickEventHook<Item>() {
            @Override
            public void onClick(View v, int position, FastAdapter<Item> fastAdapter, Item item) {
                Toast.makeText(FastAdapterActivity.this, "SubTitle clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public View onBind(RecyclerView.ViewHolder viewHolder) {
                if (viewHolder instanceof Item.ViewHolder) {
                    return ((Item.ViewHolder) viewHolder).textViewSubTitle;
                }
                return null;
            }
        });

        fastAdapter.withEventHook(new ClickEventHook<Item>() {
            @Override
            public void onClick(View v, int position, FastAdapter<Item> fastAdapter, Item item) {
                Toast.makeText(FastAdapterActivity.this, "Title clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public View onBind(RecyclerView.ViewHolder viewHolder) {
                if(viewHolder instanceof Item.ViewHolder) {
                    return ((Item.ViewHolder) viewHolder).textViewTitle;
                }
                return null;
            }
        });
    }

}