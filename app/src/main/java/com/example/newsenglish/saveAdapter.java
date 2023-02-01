package com.example.newsenglish;

import android.content.Context;
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

public class saveAdapter extends RecyclerView.Adapter<saveAdapter.MyViewHolder>  {
    Context context;
    ArrayList<ModelClass> arrayList;

    public saveAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
       return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mtime.setText("Published At: "+arrayList.get(holder.getAdapterPosition()).getPublishAt());
        holder.mauthor.setText(arrayList.get(holder.getAdapterPosition()).getAuthor());
        holder.mheading.setText(arrayList.get(holder.getAdapterPosition()).getTitle());
        holder.mcontent.setText(arrayList.get(holder.getAdapterPosition()).getDescription());
        Glide.with(context).load(arrayList.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mheading,mcontent,mauthor,mcategory,mtime;
        CardView cardView;
        ImageView imageView;
       public MyViewHolder(@NonNull View itemView) {
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
