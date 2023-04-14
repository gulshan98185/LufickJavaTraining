package com.lufick.training.training_march_2023.fastadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

public class Item extends AbstractItem<Item, Item.ViewHolder> {
    private String title;

    public String getTitle() {
        return title;
    }

    public Item(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item;
    }

    static class ViewHolder extends FastAdapter.ViewHolder<Item>{
        TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
        }

        @Override
        public void bindView(Item item, List<Object> payloads) {
            titleTextView.setText(item.title);
        }

        @Override
        public void unbindView(Item item) {

        }
    }
}
