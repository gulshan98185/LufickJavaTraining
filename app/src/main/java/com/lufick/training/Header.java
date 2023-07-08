package com.lufick.training;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class Header extends AbstractItem<Header, Header.HeaderViewHolder> {
    String title;

    public Header(String title){
        this.title = title;
    }

    @NonNull
    @Override
    public HeaderViewHolder getViewHolder(View v) {
        return new HeaderViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.header_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.header_item;
    }

    class HeaderViewHolder extends FastAdapter.ViewHolder<Header>{
        TextView headerTitle;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.header_title);
        }

        @Override
        public void bindView(Header item, List<Object> payloads) {
            headerTitle.setText(item.title);
        }

        @Override
        public void unbindView(Header item) {

        }
    }
}
