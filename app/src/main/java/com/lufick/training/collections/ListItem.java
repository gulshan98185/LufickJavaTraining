package com.lufick.training.collections;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lufick.training.R;
import com.lufick.training.call_back.CallbackUsage;
import com.lufick.training.fastadapter.DATA;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;
import java.util.Objects;

public class ListItem extends AbstractItem<ListItem, ListItem.ListViewHolder> {

    public Student student;
    public ListItem(Student student){
        this.student = student;
    }

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
            title.setText(item.student.getName());
            subtitle.setText(item.student.getFatherName() +" rollNo: "+ item.student.getRollNO());
        }

        @Override
        public void unbindView(ListItem item) {
            title.setText(null);
            subtitle.setText(null);
            icon.setImageDrawable(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return (student.getName().equals(((ListItem) o).student.getName())) && (student.getFatherName().equals(((ListItem) o).student.getFatherName()));
    }

    @Override
    public int hashCode() {
        return student.getRollNO();
    }
}
