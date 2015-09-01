package com.example.asingh19.coffeefinder.service;
import com.example.asingh19.coffeefinder.data.ResponseObject;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by asingh19 on 8/11/15.
 * Makes FoursquareAPI requests for coffee
 */
public interface CoffeeService {
    @GET("/v2/venues/explore")
    void coffeeShops(@Query("ll") String location, @Query("query") String category, @Query("radius") int radius, Callback<ResponseObject> cb);
}
