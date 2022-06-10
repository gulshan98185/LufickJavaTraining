package com.lufick.training.fastadapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

public class ListItem extends AbstractItem<ListItem, ListItem.ListViewHolder> {

    DATA data;

    public ListItem(DATA data){
        this.data = data;
    }

//    public void changeTitle(String newTitle){
//        this.title = newTitle;
//    }

    @NonNull
    @Override
    public ListViewHolder getViewHolder(View v) {
        return new ListViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.list_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    static class ListViewHolder extends FastAdapter.ViewHolder<ListItem>{
        IconicsImageView icon;
        TextView title, subtitle;
        public ListViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.sub_title);
        }

        @Override
        public void bindView(ListItem item, List payloads) {
            title.setText(item.data.title);
            subtitle.setText(item.data.subtitle);
            IconicsDrawable drawable = new IconicsDrawable(itemView.getContext(), item.data.iconName);
            if (item.data==DATA.NEERAJ){
                drawable = drawable.color(Color.RED).alpha(100);
            }else if (item.data==DATA.ABAC){
                drawable = drawable.color(Color.BLUE);
            }else {
                drawable = drawable.color(Color.RED);
            }
            icon.setImageDrawable(drawable);
        }

        @Override
        public void unbindView(ListItem item) {
            title.setText(null);
            subtitle.setText(null);
            icon.setImageDrawable(null);
        }
    }
}
