package com.lufick.training.fastadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lufick.training.R;
import com.lufick.training.call_back.MyCallBack;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

public class HeaderItem extends AbstractItem<HeaderItem, HeaderItem.ListViewHolder> {

    String title;
    MyCallBack callBack;

    public HeaderItem(String title, MyCallBack callBack){
        this.title = title;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ListViewHolder getViewHolder(View v) {
        return new ListViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.header_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.header_item;
    }

    static class ListViewHolder extends FastAdapter.ViewHolder<HeaderItem>{
        TextView title;
        public ListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.header);
        }

        @Override
        public void bindView(HeaderItem item, List payloads) {
            title.setText(item.title);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.callBack.click(getAdapterPosition());
                }
            });
        }

        @Override
        public void unbindView(HeaderItem item) {
            title.setText(null);
        }
    }
}
