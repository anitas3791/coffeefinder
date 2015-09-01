package com.example.asingh19.coffeefinder.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asingh19 on 8/24/15.
 */
public class Location implements Serializable {

    String address;
    String crossStreet;
    double lat;
    double lng;
    int distance;
    int postalCode;
    String cc;
    String city;
    String state;
    String country;
    List<String> formattedAddress;

    public Location() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

}
