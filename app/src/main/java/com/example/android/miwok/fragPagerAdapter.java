package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by home on 7/22/2017.
 */

public class fragPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    public fragPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int arg0){
        myFrag myFragment = new myFrag();
        Bundle data = new Bundle();
        data.putInt("current_page", arg0+1);
        myFragment.setArguments(data);
        return myFragment;

    }
    @Override
    public int getCount(){
        return PAGE_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "NUMBERS";

            case 1:
                return "FAMILY";
            case 2:
                return "COLORS";
            case 3:
                return "PHRASES";
        }
        return null;
    }
}
