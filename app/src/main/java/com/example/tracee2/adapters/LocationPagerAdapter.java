package com.example.tracee2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tracee2.models.Business;
import com.example.tracee2.ui.LocationDetailFragment;

import java.util.List;

public class LocationPagerAdapter extends FragmentPagerAdapter {

    private List<Business> mLocation;

    public LocationPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Business> restaurants) {
        super(fm, behavior);
        mLocation = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return LocationDetailFragment.newInstance(mLocation.get(position));
    }

    @Override
    public int getCount() {
        return mLocation.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLocation.get(position).getName();
    }
}