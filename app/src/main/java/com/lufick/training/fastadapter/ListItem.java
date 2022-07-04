package com.lufick.training.fastadapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lufick.training.R;
import com.lufick.training.call_back.CallbackUsage;
import com.lufick.training.call_back.MyCallBack;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

public class ListItem extends AbstractItem<ListItem, ListItem.ListViewHolder> {

    public DATA data;
    public CallbackUsage callBack;

    public ListItem(DATA data, CallbackUsage callBack){
        this.data = data;
        this.callBack = callBack;
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
        ConstraintLayout parentLayout;
        public ListViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.sub_title);
            parentLayout = itemView.findViewById(R.id.list_item);
        }

        @Override
        public void bindView(ListItem item, List payloads) {
            if (item.isSelected()){
                parentLayout.setBackgroundColor(Color.GREEN);
            }else {
                parentLayout.setBackgroundColor(0);
            }
            title.setText(item.data.title);
            subtitle.setText(item.data.subtitle);
            IconicsDrawable drawable = new IconicsDrawable(itemView.getContext(), item.data.iconName);
            /*if (item.data==DATA.NEERAJ){
                drawable = drawable.color(Color.RED).alpha(100);
            }else if (item.data==DATA.ABAC){
                drawable = drawable.color(Color.BLUE);
            }else {
                drawable = drawable.color(Color.RED);
            }*/
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.callBack.click(getAdapterPosition());
                }
            });
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.callBack.clickItem(item.data.title);
                }
            });
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
