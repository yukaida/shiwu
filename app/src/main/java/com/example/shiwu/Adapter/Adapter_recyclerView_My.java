package com.example.shiwu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.MyF_Item;

import java.util.List;

public class Adapter_recyclerView_My extends RecyclerView.Adapter<Adapter_recyclerView_My.ViewHolder> {
    private List<MyF_Item> list;

    public Adapter_recyclerView_My(List<MyF_Item> list) {
        super();
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyF_Item item = list.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.textView.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.MyF_item_imageView);
            textView = itemView.findViewById(R.id.MyF_item_textview);
        }
    }
}
