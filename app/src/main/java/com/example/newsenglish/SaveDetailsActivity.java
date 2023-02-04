package com.example.newsenglish;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SaveDetailsActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   private  saveAdapter sAdapter;
    private DbHelper dbHelper;
    private ArrayList<ModelClass> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_details);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(SaveDetailsActivity.this));
        list=new ArrayList<>();
        dbHelper=new DbHelper(SaveDetailsActivity.this);
        dbHelper.addNewCourse(" url","img","publish","author","title","hi,this is a demo");
        dbHelper.addNewCourse(" url1","img","publish","author","title","hi,this is a demo");
        dbHelper.addNewCourse(" url2","img","publish","author","title","hi,this is a demo");
        dbHelper.addNewCourse(" url3","img","publish","author","title","hi,this is a demo");
//        list=dbHelper.readCourses();
//        list.add(new ModelClass("g","iug","hg","","",""));
        sAdapter=new saveAdapter(this,list);
        recyclerView.setAdapter(sAdapter);

    }
}