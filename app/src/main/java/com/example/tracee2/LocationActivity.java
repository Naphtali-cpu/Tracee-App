package com.example.tracee2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class LocationActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] trail = new String[] {"Abrams Falls", "Albright Grove",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Alum Cave", "Andrews Bald", "Appalachian Trail", "Avent Cabin",
            "Balsam High Top", "Baskins Creek Falls", "Benton MacKaye Trail",
            "Big Creek / Mouse Creek Falls", "Big Fork Ridge Loop", "Boogerman Loop", "Bullhead Trail", "Cataloochee Divide", "Charlies Bunion", "Chasteen Creek Cascade", "Chestnut Top", "Chimney Tops", "Cove Mountain", "Cucumber Gap Loop", "Curry Mountain Trail"};
    private String[] location = new String[] {"Cades Cove / Townsend", "Greenbrier",
            "Gatlinburg", "Newfound", "Great Smoky Mountains", "Elkmont",
            "Balsam Mountain", "Gatlinburg / Mt. LeConte", "Big Creek", "Cataloochee",
            "Cataloochee", "Elkmont", "Nyanyuki",
            "Kiambu", "Karura", "Kisii", "Nairobi", "Mombasa", "Kijabe", "Nyahururu", "Kajiado", "Lamu", "Malindi", "Naivasha", "Nyeri" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

        LocationArrayAdapter adapter = new LocationArrayAdapter(this, android.R.layout.simple_list_item_1, trail, location);
        mListView.setAdapter(adapter);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Trails near " + location);
    }
}