package com.lufick.training.training_march_2023.fastadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.select.SelectExtension;

import java.util.ArrayList;

public class March2023FastAdapterActivity extends AppCompatActivity {
    RecyclerView fastAdapterRecyclerView;
    FastAdapter<AbstractItem> fastAdapter;
    ItemAdapter<AbstractItem> itemItemAdapter;
    SelectExtension<AbstractItem> itemSelectExtension;

    MenuItem deleteItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_march2023_fast_adapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle("FastAdapter");
        }

        fastAdapterRecyclerView = findViewById(R.id.fastadapter_rv);
        itemItemAdapter = new ItemAdapter<>();
        fastAdapter = FastAdapter.with(itemItemAdapter);
        fastAdapterRecyclerView.setAdapter(fastAdapter);
        itemSelectExtension = new SelectExtension<>();
        fastAdapter.addExtension(itemSelectExtension);
        itemSelectExtension.withAllowDeselection(true);
        itemSelectExtension.withSelectOnLongClick(true);

        itemSelectExtension.withSelectable(true);
        itemSelectExtension.withSelectWithItemUpdate(true);
        itemSelectExtension.withMultiSelect(true);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        fastAdapterRecyclerView.setLayoutManager(gridLayoutManager);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if(itemItemAdapter.getAdapterItem(position) instanceof HeaderItem){
//                    return 3;
//                }else {
//                    return 1;
//                }
//            }
//        });



        ArrayList<AbstractItem> itemArrayList = new ArrayList<>();
        for (int i = 0; i<50; i++){
            if(i%3==0){
                itemArrayList.add(new HeaderItem("header no "+(i+1)));
            }else {
                itemArrayList.add(new Item("Item " + (i + 1)));
            }
        }

        fastAdapter.withOnClickListener(new OnClickListener<AbstractItem>() {
            @Override
            public boolean onClick(View v, IAdapter<AbstractItem> adapter, AbstractItem item, int position) {
                if(item instanceof Item) {
                    if(itemSelectExtension.getSelectedItems().size()>0){
                        if(item.isSelected()){
                            itemSelectExtension.deselect(position);
                        }else {
                            itemSelectExtension.select(position);
                        }
                    }
                    Toast.makeText(March2023FastAdapterActivity.this, "header item is "+((Item) item).getTitle(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        fastAdapter.withOnLongClickListener(new OnLongClickListener<AbstractItem>() {
            @Override
            public boolean onLongClick(View v, IAdapter<AbstractItem> adapter, AbstractItem item, int position) {
                if(item instanceof HeaderItem){
                    itemSelectExtension.deselect(position);
                }
                return false;
            }
        });

        itemSelectExtension.withSelectionListener(new ISelectionListener<AbstractItem>() {
            @Override
            public void onSelectionChanged(AbstractItem item, boolean selected) {
                if(itemSelectExtension.getSelectedItems().size()>0){
                    deleteItem.setVisible(true);
                }else {
                    deleteItem.setVisible(false);
                }
            }
        });

        itemItemAdapter.setNewList(itemArrayList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        deleteItem = menu.findItem(R.id.action_delete);
        MenuItem copyItem = menu.findItem(R.id.action_copy);
        deleteItem.setVisible(false);
        copyItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_delete){
            if(itemSelectExtension!=null && itemSelectExtension.getSelectedItems().size()>0) {
                for (AbstractItem element : itemSelectExtension.getSelectedItems()) {
                    int position = fastAdapter.getPosition(element);
                    itemItemAdapter.remove(position);
                    fastAdapter.notifyItemRemoved(position);
                }
                deleteItem.setVisible(false);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}