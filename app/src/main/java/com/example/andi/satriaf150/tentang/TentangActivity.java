package com.example.andi.satriaf150.tentang;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andi.satriaf150.R;

public class TentangActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Pager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new Pager(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final TabLayout.Tab motor = tabLayout.newTab();
        final TabLayout.Tab aplikasi = tabLayout.newTab();
        final TabLayout.Tab pembuat = tabLayout.newTab();

        motor.setIcon(R.drawable.ic_motorcycle_black_24dp);
        aplikasi.setIcon(R.drawable.ic_phone_android_black_24dp);
        pembuat.setIcon(R.drawable.ic_person_black_24dp);

        tabLayout.addTab(motor, 0);
        tabLayout.addTab(aplikasi, 1);
        tabLayout.addTab(pembuat, 2);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_sector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.alertInfo));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: {
                        motor.setIcon(R.drawable.ic_motorcycle_white);
                        aplikasi.setIcon(R.drawable.ic_phone_android_black_24dp);
                        pembuat.setIcon(R.drawable.ic_person_black_24dp);
                        break;
                    }
                    case 1: {
                        motor.setIcon(R.drawable.ic_motorcycle_black_24dp);
                        aplikasi.setIcon(R.drawable.ic_phone_white);
                        pembuat.setIcon(R.drawable.ic_person_black_24dp);
                        break;
                    }
                    case 2: {
                        motor.setIcon(R.drawable.ic_motorcycle_black_24dp);
                        aplikasi.setIcon(R.drawable.ic_phone_android_black_24dp);
                        pembuat.setIcon(R.drawable.ic_person_white);
                        break;
                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
