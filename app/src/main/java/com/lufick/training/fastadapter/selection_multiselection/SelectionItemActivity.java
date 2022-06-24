package com.lufick.training.fastadapter.selection_multiselection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lufick.training.R;
import com.lufick.training.fastadapter.DATA;
import com.lufick.training.fastadapter.HeaderItem;
import com.lufick.training.fastadapter.ListItem;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

public class SelectionItemActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<AbstractItem> fastAdapter;
    ItemAdapter<AbstractItem> itemAdapter;
    List<AbstractItem> itemList;
    SelectExtension<AbstractItem> selectExtension;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_item);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Selection and Multi");

        recyclerView = findViewById(R.id.selection_rv);
        itemAdapter = ItemAdapter.items();
        fastAdapter = FastAdapter.with(itemAdapter);
        fastAdapter.withSelectOnLongClick(true);
        fastAdapter.withSelectable(true);
        fastAdapter.withMultiSelect(true);
        fastAdapter.withAllowDeselection(true);
        fastAdapter.withSelectWithItemUpdate(true);

        selectExtension = fastAdapter.getExtension(SelectExtension.class);

        fastAdapter.withOnPreLongClickListener((v, adapter, item, position) -> item instanceof HeaderItem);
        fastAdapter.withOnLongClickListener((v, adapter, item, position) -> {
            Toast.makeText(SelectionItemActivity.this, "Long click fired", Toast.LENGTH_SHORT).show();
            return true;
        });
        fastAdapter.withOnPreClickListener((v, adapter, item, position) -> {
//                if (item.data==DATA.BUS){
//                    Toast.makeText(SelectionItemActivity.this, "You cannot click this item", Toast.LENGTH_SHORT).show();
//                    return true;
//                }
            if (selectExtension.getSelectedItems().size()>0) {
                if (item instanceof ListItem) {
                    if (!item.isSelected()) {
                        selectExtension.select(position, false);
                    } else {
                        selectExtension.deselect(position);
                    }
                    return true;
                }
            }
            return false;
        });

        fastAdapter.withOnClickListener((v, adapter, item, position) -> {
            Toast.makeText(SelectionItemActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            return false;
        });

        selectExtension.withSelectionListener((ISelectionListener) (item, selected) -> {
            if (selectExtension.getSelectedItems().size()>0){
                toolbar.setTitle(selectExtension.getSelectedItems().size() + " Items selected");
                toolbar.getMenu().findItem(R.id.action_delete).setVisible(true);
                toolbar.getMenu().findItem(R.id.action_copy).setVisible(true);
            }else {
                toolbar.setTitle("Selection and Multi");
                toolbar.getMenu().findItem(R.id.action_delete).setVisible(false);
                toolbar.getMenu().findItem(R.id.action_copy).setVisible(false);
            }
        });

        recyclerView.setAdapter(fastAdapter);
        itemList = new ArrayList<>();
        itemList.add(new HeaderItem("Header"));
        for (DATA data : DATA.values()){
            itemList.add(new ListItem(data));
        }
        itemList.add(new HeaderItem("Footer"));
        itemAdapter.setNewList(itemList);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_delete).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_delete).color(Color.WHITE).sizeDp(24).paddingDp(2));
        menu.findItem(R.id.action_copy).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_content_copy).color(Color.WHITE).sizeDp(24).paddingDp(2));
        menu.findItem(R.id.action_copy).setVisible(false);
        menu.findItem(R.id.action_delete).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_copy:
                //do something
                break;
            case R.id.action_delete:
                for (AbstractItem item1: selectExtension.getSelectedItems()){
                    if (item1 instanceof ListItem) {
                        int index = itemAdapter.getAdapterPosition(item1);
                        itemAdapter.remove(index);
                        fastAdapter.notifyItemChanged(index);
                        toolbar.setTitle("Selection and Multi");
                        toolbar.getMenu().findItem(R.id.action_delete).setVisible(false);
                        toolbar.getMenu().findItem(R.id.action_copy).setVisible(false);
                    }
                }
                break;
            default:
                //
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}