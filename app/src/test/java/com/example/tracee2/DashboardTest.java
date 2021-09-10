package com.example.tracee2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import android.content.Intent;
import android.widget.TextView;

import com.example.tracee2.ui.Dashboard;
import com.example.tracee2.ui.LocationActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
@RunWith(RobolectricTestRunner.class)
public class DashboardTest {
    private Dashboard activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(Dashboard.class)
                .create()
                .resume()
                .get();
    }
    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = activity.findViewById(R.id.findRestaurantsButton);
        assertEquals("Lets adventure!", "Lets adventure!");
    }
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, LocationActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}