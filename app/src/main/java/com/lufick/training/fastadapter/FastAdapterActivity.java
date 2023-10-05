package com.lufick.training.fastadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lufick.training.Header;
import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.select.SelectExtension;

import java.util.ArrayList;
import java.util.List;

public class FastAdapterActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    FastAdapter<AbstractItem> fastAdapter;
    ItemAdapter<AbstractItem> itemAdapter;

    SelectExtension<AbstractItem> selectExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_adapter);
        recyclerView = findViewById(R.id.recycler_view);
        button = findViewById(R.id.btn);
        itemAdapter = ItemAdapter.items();
        fastAdapter = FastAdapter.with(itemAdapter);
        fastAdapter.withSelectable(true);
        fastAdapter.withMultiSelect(true);
        fastAdapter.withSelectWithItemUpdate(true);
        fastAdapter.withSelectOnLongClick(true);
        selectExtension = fastAdapter.getExtension(SelectExtension.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastAdapter);
        ArrayList<AbstractItem> itemArrayList = new ArrayList<>();
        for (int i=1; i<=100; i++){
            Item item = new Item("Title "+i);
            itemArrayList.add(item);
            if(i%5==0){
                Header header = new Header("Header "+i);
                itemArrayList.add(header);
            }
        }

        itemAdapter.setNewList(itemArrayList);
        fastAdapter.withOnClickListener(new OnClickListener<AbstractItem>() {
            @Override
            public boolean onClick(View v, IAdapter<AbstractItem> adapter, AbstractItem item, int position) {
                if (item instanceof Item) {
                    if(selectExtension.getSelectedItems().size()>0) {
                        if (((Item) item).isSelected()) {
                            selectExtension.deselect(position);
                        } else {
                            selectExtension.select(position);
                        }
                    }
                }
                return false;
            }
        });

        fastAdapter.withOnLongClickListener(new OnLongClickListener<AbstractItem>() {
            @Override
            public boolean onLongClick(View v, IAdapter<AbstractItem> adapter, AbstractItem item, int position) {
                if (item instanceof Item) {
                    Toast.makeText(FastAdapterActivity.this, ((Item) item).getTitle(), Toast.LENGTH_SHORT).show();
                } else if (item instanceof Header) {
                    selectExtension.deselect(position);
                    Toast.makeText(FastAdapterActivity.this, "Header is clicked", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        fastAdapter.withEventHook(new ClickEventHook<AbstractItem>() {
            @Override
            public void onClick(View v, int position, FastAdapter<AbstractItem> fastAdapter, AbstractItem item) {
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

        fastAdapter.withEventHook(new ClickEventHook<AbstractItem>() {
            @Override
            public void onClick(View v, int position, FastAdapter<AbstractItem> fastAdapter, AbstractItem item) {
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

        selectExtension.withSelectionListener(new ISelectionListener<AbstractItem>() {
            @Override
            public void onSelectionChanged(AbstractItem item, boolean selected) {
                if(item instanceof Item) {
                    button.setEnabled(selectExtension.getSelectedItems().size() > 0);
                }
            }
        });
    }

}