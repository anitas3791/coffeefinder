package com.example.asingh19.coffeefinder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by asingh19 on 8/31/15.
 * This Activity represents the screen that opens up to show more details about a venue (coffeeshop) when
 * you click on a pin's info window
 */
public class VenueActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venue_activity);
    }
}
