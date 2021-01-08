package com.example.andi.satriaf150.tentang;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Pager extends FragmentStatePagerAdapter {

    public Pager (FragmentManager fm){
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new motor();
            case 1:
                return new aplikasi();
            case 2:
                pembuat pembuat = new pembuat();
                return pembuat;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
