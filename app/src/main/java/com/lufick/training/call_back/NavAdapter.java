package com.lufick.training.call_back;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lufick.training.R;

import java.time.temporal.Temporal;
import java.util.List;

public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder> {

    List<String> navTitleList;
    MyCallBack myCallBack;
    MyAbstractCallBack myAbstractCallBack;

    public NavAdapter(List<String> navTitle, MyCallBack myCallback, MyAbstractCallBack myAbstractCallBack){
        this.navTitleList = navTitle;
        this.myCallBack = myCallback;
        this.myAbstractCallBack = myAbstractCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(navTitleList.get(position));
        holder.itemView.setOnClickListener(v -> {
            //myAbstractCallBack.doItNow();

            myAbstractCallBack.doNotDoIt();

//            String name = myCallBack.click(holder.getAdapterPosition());
//            holder.textView.setText(name);
        });
    }

    @Override
    public int getItemCount() {
        return navTitleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
