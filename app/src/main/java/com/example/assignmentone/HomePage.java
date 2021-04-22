package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomePage extends AppCompatActivity {
  TabLayout tabone;
  TabItem slideone,slide2;
  ViewPager viewPage;
  PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tabone = findViewById(R.id.tabLayout);
        slideone = findViewById(R.id.slideOne);
        slide2=findViewById(R.id.slideTwo);
        viewPage=findViewById(R.id.vPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabone.getTabCount());
        viewPage.setAdapter(pageAdapter);
        tabone.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPage.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // For Scroll Page Change
        viewPage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabone));

    }


}