package com.lufick.training.fastadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class Item extends AbstractItem<Item, Item.ViewHolder> {
    private String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    class ViewHolder extends FastAdapter.ViewHolder<Item>{
        public TextView textViewTitle, textViewSubTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewSubTitle = itemView.findViewById(R.id.sub_title);
        }

        @Override
        public void bindView(Item item, List<Object> payloads) {
            textViewTitle.setText(item.title);
            textViewSubTitle.setText("SubTitle");
        }

        @Override
        public void unbindView(Item item) {
            textViewTitle.setText(null);
            textViewSubTitle.setText(null);
        }
    }
}
