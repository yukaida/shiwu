package com.example.shiwu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.HomeF_item;

import java.util.List;

public class Adapter_recyclerView_home extends RecyclerView.Adapter<Adapter_recyclerView_home.ViewHolder> {
    private List<HomeF_item> list;

    public Adapter_recyclerView_home(List<HomeF_item> list) {
        super();
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeF_item item = list.get(position);
        holder.textView_name.setText(item.getName());
        holder.imageView.setImageResource(item.getImage());
        holder.textView_describe.setText(item.getDescribe());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView_name;
        TextView textView_describe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_HomeF_rv);
            textView_name = itemView.findViewById(R.id.textView_HomeF_rv_name);
            textView_describe = itemView.findViewById(R.id.textView_HomeF_rv_describe);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "子项被点击", Toast.LENGTH_SHORT).show();
                }
            });

        }



    }
}
