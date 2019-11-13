package com.example.shiwu.Adapter;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.KindOfA_item;

import java.util.List;

public class Adapter_recyclerView_kindofthings extends RecyclerView.Adapter<Adapter_recyclerView_kindofthings.ViewHolder>{
    private List<KindOfA_item> list;
    private Context context;
    public Adapter_recyclerView_kindofthings(Context context,List list) {
        super();
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindofthings_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KindOfA_item item = list.get(position);
        holder.imageView.setImageResource(item.getId());
        holder.textView.setText(item.getDescribe());
        holder.button.setText(item.getQq());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + 1561072562 + "&version=1"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_kindofthings);
            textView = itemView.findViewById(R.id.textView_kindofthings);
            button = itemView.findViewById(R.id.button_kindofthins);
        }
    }
}
