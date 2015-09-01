package com.example.asingh19.coffeefinder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.asingh19.coffeefinder.data.Group;
import com.example.asingh19.coffeefinder.data.Item;
import com.example.asingh19.coffeefinder.data.ResponseObject;
import com.example.asingh19.coffeefinder.data.Venue;
import com.example.asingh19.coffeefinder.data.VenueList;

import com.example.asingh19.coffeefinder.service.RestClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The app opens to MapsActivity which lays out the map with the coffee pins
 */

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Map<String, Venue> markerVenueMap;
    public final static String VENUE_MARKER = "VENUE";
    private String longitude;
    private String latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    /**
     * Makes Foursquare API call for coffee shops using Retrofit each time the app is resumed
     */
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        RestClient.getInstance().getCoffeeService().coffeeShops(latitude + "," + longitude, "coffee", 1000, //making network call
            new Callback<ResponseObject>() {
                @Override
                public void success(ResponseObject responseObject, Response response) { //populate data upon success
                    populateData(responseObject);
                    populateMap();
                }
                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(MapsActivity.this, R.string.server_error, Toast.LENGTH_LONG);
                    Log.e("Error getting coffee", error.toString());
                }
            });
    }
    /**
     * Handling click on title window of marker
     */
    @Override
    public void onInfoWindowClick(Marker marker) {
        Venue currentVenue = markerVenueMap.get(marker.getId());
        Intent myIntent = new Intent();
        myIntent.putExtra(VENUE_MARKER, currentVenue);
        myIntent.setClassName(this, VenueActivity.class.getName());
        startActivity(myIntent);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
    */
    private void setUpMapIfNeeded() {
        if (mMap == null) { // Checking if we have already instantiated the map.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
        markerVenueMap = new HashMap<String, Venue>();
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);//use of location services by firstly defining location manager.
        boolean isNetworkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!isNetworkEnabled && !isGPSEnabled) {
            showLocationDialog(); //for example, if on airplane mode show dialog to turn on location settings
            return;
        }
        Location loc = lm.getLastKnownLocation(isNetworkEnabled == true ? LocationManager.NETWORK_PROVIDER : LocationManager.GPS_PROVIDER);
        LatLng myLocation = new LatLng(loc.getLatitude(), loc.getLongitude());
        latitude = new Double(loc.getLatitude()).toString();
        longitude = new Double(loc.getLongitude()).toString();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 14)); //having a reasonable zoom near my location
        mMap.addMarker(new MarkerOptions()
                .title(getResources().getString(R.string.location))
                .position(myLocation));
        populateMap(); //populate the map with any previous data in memory (caching)
    }

    /**
     * Method to populate the VenueList with venues
     * @param responseObject: An object representing response from server
     */
    private void populateData(ResponseObject responseObject) {
        List<Group> groups = responseObject.getResponse().getGroups();
        List<Venue> venues = new ArrayList<Venue>();
        for (Group group: groups) {
            for (Item item : group.getItems()) {
                venues.add(item.getVenue());
            }
        }
        VenueList.getInstance().setVenues(venues);
    }

    /**
     * Populate map with nearby venues we obtain from network call
     */
    private void populateMap() {
        mMap.setOnInfoWindowClickListener(this);
        List<Venue> venues = VenueList.getInstance().getVenues();
        if (venues != null && venues.size() > 0) {
            for (int i = 0; i < venues.size(); i++) {
                Venue venue = venues.get(i);
                String markerId = mMap.addMarker(new MarkerOptions() //adding markers for each location
                        .title(venue.getName())
                        .position(new LatLng(venue.getLocation().getLat(), venue.getLocation().getLng()))).getId();
                markerVenueMap.put(markerId, venue);
            }
        }
    }

    /**
     Show dialog to allow user to enable location settings
     */
    private void showLocationDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MapsActivity.this);
        dialog.setTitle(R.string.location_unavailable);
        dialog.setMessage(R.string.enable_location);
        dialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
            }
        });
        dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.create();
        dialog.show();
    }

}
