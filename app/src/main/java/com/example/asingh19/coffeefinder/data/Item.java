package com.example.asingh19.coffeefinder.data;
/**
 * Created by asingh19 on 8/24/15.
 */
public class Item {
    Venue venue;
    public Item(Venue venue) {
        this.venue = venue;
    }
    public Item() { }
    public Venue getVenue() {
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
