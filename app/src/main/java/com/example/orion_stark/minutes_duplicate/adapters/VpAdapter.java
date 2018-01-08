package com.example.orion_stark.minutes_duplicate.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orionstark on 12/9/17.
 */

public class VpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public void setFragment(Fragment fragment, String title) {
        this.fragmentList.add(fragment);
        this.titles.add(title);
    }
    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return this.titles.get(position);
    }

    @Override
    public Fragment getItem(final int position) {
        return this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentList.size();
    }

}
