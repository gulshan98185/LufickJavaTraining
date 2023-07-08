package com.lufick.training;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

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
        return R.id.my_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.my_item;
    }

    class ViewHolder extends FastAdapter.ViewHolder<MyItem>{
        TextView textView;
        ConstraintLayout parent;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            parent = itemView.findViewById(R.id.my_item);
        }

        @Override
        public void bindView(MyItem item, List<Object> payloads) {
            textView.setText(item.name);
            if(item.isSelected()){
                parent.setBackgroundColor(Color.RED);
            }else {
                parent.setBackgroundColor(0);
            }
        }

        @Override
        public void unbindView(MyItem item) {
            textView.setText(null);
        }
    }
}
