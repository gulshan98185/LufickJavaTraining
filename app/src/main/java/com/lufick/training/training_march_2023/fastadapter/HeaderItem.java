package com.lufick.training.training_march_2023.fastadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class HeaderItem extends AbstractItem<HeaderItem, HeaderItem.ViewHolder> {

    public String header;


    public HeaderItem(String header) {
        this.header = header;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.header_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.header_item;
    }

    static class ViewHolder extends FastAdapter.ViewHolder<HeaderItem>{
        TextView headerTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.header);
        }

        @Override
        public void bindView(HeaderItem item, List<Object> payloads) {
            headerTextView.setText(item.header);
        }

        @Override
        public void unbindView(HeaderItem item) {
            headerTextView.setText(null);
        }
    }
}
