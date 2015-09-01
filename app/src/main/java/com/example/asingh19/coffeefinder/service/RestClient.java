package com.example.asingh19.coffeefinder.service;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by asingh19 on 8/11/15.
 * This class uses Retrofit to set up the RestClient
 */
public class RestClient {

    private static final String BASE_URL = "https://api.foursquare.com";
    private static final String CLIENT_ID = "1KBBWXEN325YSF2I2C50NUTJMN52CCW2SL0QC14TNBT2KWBT";
    private static final String CLIENT_SECRET = "EJMGBDIN0JTESV01N3ZOJ33ZZCW2FAW02XBNOOHIUBQVSLGS";
    private CoffeeService coffeeService;
    private static RestClient restClient; //making this singleton as there should only be one RestClient for the app

    public static RestClient getInstance() {
        if (restClient == null) {
            restClient = new RestClient();
        }
        return restClient;
    }

    private RestClient() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() //this is added to every request
        {
            @Override
            public void intercept(RequestFacade request) {
                request.addQueryParam("client_id", CLIENT_ID);
                request.addQueryParam("client_secret", CLIENT_SECRET);
                request.addQueryParam("v", "20150801");
                request.addQueryParam("m", "foursquare");
            }
        };
        RestAdapter restAdapter = new RestAdapter.Builder() //Retrofit will by default use Gson to convert response
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();
        coffeeService = restAdapter.create(CoffeeService.class);
    }

    public CoffeeService getCoffeeService() {
        return coffeeService;
    }
}
