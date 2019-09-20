package com.example.shiwu.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.MesF_item;

import java.util.List;

public class Adapter_recyclerView_Mes extends RecyclerView.Adapter<Adapter_recyclerView_Mes.ViewHolder> {
    private List<String> list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_mes_recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MesF_item item = new MesF_item();
        item.setString(list.get(position));
        holder.textView.setText(item.getString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.MesF_textView);
        }
    }

    public Adapter_recyclerView_Mes(List<String> list) {
        super();
        this.list = list;
    }
}
