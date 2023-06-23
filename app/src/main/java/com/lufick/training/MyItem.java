package com.lufick.training;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class MyItem extends AbstractItem<MyItem, MyItem.ViewHolder> {
    private String name;

    public MyItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
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
        return R.layout.my_item;
    }

    class ViewHolder extends FastAdapter.ViewHolder<MyItem>{
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        @Override
        public void bindView(MyItem item, List<Object> payloads) {
            textView.setText(item.name);
        }

        @Override
        public void unbindView(MyItem item) {
            textView.setText(null);
        }
    }
}
