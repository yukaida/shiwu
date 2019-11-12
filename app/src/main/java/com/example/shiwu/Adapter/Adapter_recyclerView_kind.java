package com.example.shiwu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.Activity.KindofThingsActivity;
import com.example.shiwu.Activity.StartActivity;
import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.KindF_item;

import java.nio.file.WatchEvent;
import java.util.List;

public class Adapter_recyclerView_kind extends RecyclerView.Adapter<Adapter_recyclerView_kind.ViewHolder> {
    private final Context context;
    private List<KindF_item> list;
    private static final String TAG = "Adapter_recyclerView_ki";
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

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Log.d(TAG, "onClick: " + position);
                        Intent intent = new Intent(context, KindofThingsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Log.d(TAG, "onClick: " + position);
                        break;

                }
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.kindF_imageView);
            textView = itemView.findViewById(R.id.kindF_textView);

        }
    }

    public Adapter_recyclerView_kind(Context context,List<KindF_item> list) {
        super();
        this.list = list;
        this.context = context;
    }
}
