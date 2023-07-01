package com.lufick.training.callback;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

public class ItemList extends AbstractItem<ItemList, ItemList.ViewHolder> {
    String title, subtitle;
    ItemCallback myCallback;

    public ItemList(String title, String subtitle, ItemCallback myCallback){
        this.title = title;
        this.subtitle = subtitle;
        this.myCallback = myCallback;
    }
    @NonNull
    @Override
    public ItemList.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.list_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    class ViewHolder extends FastAdapter.ViewHolder<ItemList>{
        IconicsImageView icon;
        TextView title, subTitle;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.sub_title);
            parentLayout = itemView.findViewById(R.id.list_item);
        }

        @Override
        public void bindView(ItemList item, List<Object> payloads) {
            title.setText(item.title);
            subTitle.setText(item.subtitle);
            icon.setIcon(new IconicsDrawable(itemView.getContext(), GoogleMaterial.Icon.gmd_alarm));
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.myCallback.clickIcon();
                }
            });

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   item.myCallback.clickParent();
                }
            });
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.myCallback.clickSomething();
                }
            });
        }

        @Override
        public void unbindView(ItemList item) {
            title.setText(null);
            subTitle.setText(null);
            icon.setIcon(null);
        }
    }
}
