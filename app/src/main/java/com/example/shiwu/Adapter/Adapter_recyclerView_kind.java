package com.example.shiwu.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.KindF_item;

import java.nio.file.WatchEvent;
import java.util.List;

public class Adapter_recyclerView_kind extends RecyclerView.Adapter<Adapter_recyclerView_kind.ViewHolder> {
    private List<KindF_item> list;
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kind_recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KindF_item item = list.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.textView.setText(item.getName());
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
            imageView = itemView.findViewById(R.id.kindF_imageView);
            textView = itemView.findViewById(R.id.kindF_textView);
        }
    }

    public Adapter_recyclerView_kind(List<KindF_item> list) {
        super();
        this.list = list;
    }
}
