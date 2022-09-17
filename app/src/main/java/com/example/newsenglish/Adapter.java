package com.example.newsenglish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public Adapter(Context context, ArrayList<ModelClass> mClassarrayList) {
        this.context = context;
        this.mClassarrayList = mClassarrayList;
    }

    Context context;
    ArrayList<ModelClass> mClassarrayList;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,webView.class);
                intent.putExtra("url",mClassarrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mtime.setText("Published At: "+mClassarrayList.get(holder.getAdapterPosition()).getPublishAt());
        holder.mauthor.setText(mClassarrayList.get(holder.getAdapterPosition()).getAuthor());
        holder.mheading.setText(mClassarrayList.get(holder.getAdapterPosition()).getTile());
        holder.mcontent.setText(mClassarrayList.get(holder.getAdapterPosition()).getDescription());
        Glide.with(context).load(mClassarrayList.get(holder.getAdapterPosition()).getUrltoImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mClassarrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mcategory,mtime;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainHeading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            cardView=itemView.findViewById(R.id.cardView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
