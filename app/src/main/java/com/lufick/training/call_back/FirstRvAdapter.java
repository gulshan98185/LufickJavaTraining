//package com.lufick.training.call_back;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.lufick.training.R;
//
//import java.util.List;
//
//public class FirstRvAdapter extends RecyclerView.Adapter<FirstRvAdapter.ViewHolder> {
//
//    List<String> firstItemNameList;
//    MyCallBack myCallBack;
//
//    public FirstRvAdapter(List<String> firstItemNameList, MyCallBack myCallBack){
//        this.firstItemNameList = firstItemNameList;
//        this.myCallBack = myCallBack;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.textView.setText(firstItemNameList.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //chawal dedo saman dedo
//                String name = myCallBack.click(holder.getAdapterPosition());
//                holder.textView.setText(name);
//                myCallBack.goForIt(holder.getAdapterPosition());
//            }
//        });
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myCallBack.clickItem(firstItemNameList.get(holder.getAdapterPosition()));
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return firstItemNameList.size();
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder{
//        TextView textView;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.item_name);
//        }
//    }
//}
