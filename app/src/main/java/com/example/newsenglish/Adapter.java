package com.example.newsenglish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    DbHelper dbHelper;
    ArrayList<ModelClass> mClassarrayList;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        holder.mtime.setText("Published At: "+mClassarrayList.get(holder.getAdapterPosition()).getPublishAt());
        holder.mauthor.setText(mClassarrayList.get(holder.getAdapterPosition()).getAuthor());
        holder.mheading.setText(mClassarrayList.get(holder.getAdapterPosition()).getTitle());
        holder.mcontent.setText(mClassarrayList.get(holder.getAdapterPosition()).getDescription());
        Glide.with(context).load(mClassarrayList.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,webView.class);
                intent.putExtra("url",mClassarrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dbHelper=new DbHelper(context);
                String url,img,publish,author,title,description;
                dbHelper.addNewCourse(" url","img","publish","author","title","hi,this is a demo");
                dbHelper.addNewCourse(" url1","img","publish","author","title","hi,this is a demo");
                dbHelper.addNewCourse(" url2","img","publish","author","title","hi,this is a demo");
                url=mClassarrayList.get(holder.getAdapterPosition()).getUrl();
                img=mClassarrayList.get(holder.getAdapterPosition()).getUrlToImage();
                publish=mClassarrayList.get(holder.getAdapterPosition()).getPublishAt();
                author=mClassarrayList.get(holder.getAdapterPosition()).getAuthor();
                title=mClassarrayList.get(holder.getAdapterPosition()).getTitle();
                description=mClassarrayList.get(holder.getAdapterPosition()).getDescription();
//                dbHelper.addNewCourse(url,img,publish,author,title,description);
                Toast.makeText(context, "Saved"+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });



//        ModelClass m=mClassarrayList.get(position);
//        holder.mheading.setText(m.getTile());
//        holder.mcontent.setText(m.getDescription());
//        Glide.with(context).load(m.getUrltoImage()).into(holder.imageView);
//        holder.mauthor.setText(m.getAuthor());
//        holder.mtime.setText(m.getPublishAt());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(context,webView.class);
//                i.putExtra("url",m.getUrl());
//                context.startActivity(i);
//            }
//        });

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
