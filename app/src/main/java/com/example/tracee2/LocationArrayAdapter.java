package com.example.tracee2;
import android.content.Context;
import android.widget.ArrayAdapter;

public class LocationArrayAdapter extends  ArrayAdapter {
    private Context mContext;
    private String[] mTrail;
    private String[] mLocation;

    public LocationArrayAdapter(Context mContext, int resource, String[] mLocation, String[] mTrail) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mTrail = mTrail;
        this.mLocation = mLocation;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mLocation[position];
        String cuisine = mTrail[position];
        return String.format("%s \nLocation: %s", restaurant, cuisine);
    }

    @Override
    public int getCount() {
        return mLocation.length;
    }
}
