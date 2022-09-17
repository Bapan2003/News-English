package com.example.newsenglish;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,mhealth,msports,mscience,mtech,menter;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    String api="3dc94c2e74ed40149be9f5fdc8744ee0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mhome=findViewById(R.id.home);
        mhealth=findViewById(R.id.health);
        msports=findViewById(R.id.sports);
        mscience=findViewById(R.id.science);
        mtech=findViewById(R.id.tech);
        menter=findViewById(R.id.entertainment);
        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        tabLayout=findViewById(R.id.include);
        pagerAdapter =new PagerAdapter(getSupportFragmentManager(),6);
       viewPager.setAdapter(pagerAdapter);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               int cur=tab.getPosition();
               if(cur==0||cur==1||cur==2||cur==3||cur==4||cur==5) {
                   pagerAdapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

        viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));

    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to exit ?");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            finish();
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
