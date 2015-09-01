package com.example.asingh19.coffeefinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asingh19.coffeefinder.data.Venue;
import com.squareup.picasso.Picasso;


/**
 * Created by asingh19 on 8/31/15.
 */
public class VenueFragment extends Fragment {

    String coffeeUrl = "http://cdn.foodbeast.com/content/uploads/2015/02/coffee-smell.jpeg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.venue_detail, container, false);
        Venue venue = (Venue) getActivity().getIntent().getSerializableExtra(MapsActivity.VENUE_MARKER); //getting venue associated with this screen

        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView ratingNumber = (TextView) rootView.findViewById(R.id.rating_number);
        TextView address = (TextView) rootView.findViewById(R.id.address);
        TextView checkinsCount = (TextView) rootView.findViewById(R.id.checkins_number);
        TextView usersCount = (TextView) rootView.findViewById(R.id.users_number);
        TextView tipsCount = (TextView) rootView.findViewById(R.id.tips_number);
        ImageView coffeeImage = (ImageView) rootView.findViewById(R.id.coffee);

        title.setText(venue.getName());
        ratingNumber.setText(venue.getRating());
        address.setText(venue.getLocation().getAddress() + "\n" + venue.getLocation().getCity());
        checkinsCount.setText(venue.getStats().getCheckinsCount().toString());
        usersCount.setText(venue.getStats().getUsersCount().toString());
        tipsCount.setText(venue.getStats().getTipCount().toString());

        Picasso.with(getActivity().getBaseContext()).load(coffeeUrl).into(coffeeImage); //loading coffee image
        return rootView;
    }
}
