package com.example.asingh19.coffeefinder.data;

import java.util.List;

/**
 * Created by asingh19 on 8/24/15.
 */
public class VenueList {

    List<Venue> venues;
    static VenueList venueList; //singleton object to keep track of venues around me

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
    public VenueList() { }

    public static VenueList getInstance() {
        if (venueList == null) {
            venueList = new VenueList();
        }
        return venueList;
    }
}
