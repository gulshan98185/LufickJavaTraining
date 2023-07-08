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
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.select.SelectExtension;

import java.util.ArrayList;
import java.util.List;

import bolts.Continuation;
import bolts.Task;

public class MyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<AbstractItem>  fastAdapter;
    ItemAdapter<AbstractItem>  itemItemAdapter;
    SelectExtension<AbstractItem> selectExtension;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        recyclerView = findViewById(R.id.recycler_view);
        itemItemAdapter = ItemAdapter.items();
        fastAdapter =  FastAdapter.with(itemItemAdapter);
        fastAdapter.withSelectOnLongClick(true);
        fastAdapter.withSelectable(true);
        fastAdapter.withSelectWithItemUpdate(true);
        fastAdapter.withAllowDeselection(true);
        fastAdapter.withMultiSelect(true);
        selectExtension = fastAdapter.getExtension(SelectExtension.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fastAdapter);


        List<AbstractItem> listOfItems = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            if(i%5==0){
                listOfItems.add(new Header("Header title " + (i+1)));
            }
            listOfItems.add(new MyItem("List item no "+(i+1)));
        }
        itemItemAdapter.setNewList(listOfItems);

        fastAdapter.withOnClickListener(new OnClickListener<AbstractItem>() {
            @Override
            public boolean onClick(View v, IAdapter<AbstractItem> adapter, AbstractItem item, int position) {
                if(item instanceof MyItem){
                    if(selectExtension.getSelectedItems().size()>0){
                        if(!item.isSelected()) {
                            selectExtension.select(position);
                        }else {
                            selectExtension.deselect(position);
                        }
                    }
                }
                return false;
            }
        });
        selectExtension.withSelectionListener(new ISelectionListener<AbstractItem>() {
            @Override
            public void onSelectionChanged(AbstractItem item, boolean selected) {
                if(selectExtension.getSelectedItems().size()>0){
                    //show delete icon
                }else {
                    // hide delete icon
                }
                if (item.isSelected()) {
                    Toast.makeText(MyActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MyActivity.this, "DeSelected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}