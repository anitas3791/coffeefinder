package com.example.asingh19.coffeefinder.data;

import java.io.Serializable;

/**
 * Created by asingh19 on 8/24/15.
 */
public class Venue implements Serializable {
    String id;
    String name;
    Contact contact;
    Location location;
    Stats stats;
    String rating;

    public Venue() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public static class Stats implements Serializable {
        Integer checkinsCount;
        Integer usersCount;
        Integer tipCount;
        Integer visitsCount;

        public Stats() {

        }
        public Integer getCheckinsCount() {
            return checkinsCount;
        }

        public void setCheckinsCount(int checkinsCount) {
            this.checkinsCount = checkinsCount;
        }

        public Integer getVisitsCount() {
            return visitsCount;
        }

        public void setVisitsCount(int visitsCount) {
            this.visitsCount = visitsCount;
        }

        public Integer getTipCount() {
            return tipCount;
        }

        public void setTipCount(int tipCount) {
            this.tipCount = tipCount;
        }

        public Integer getUsersCount() {
            return usersCount;
        }

        public void setUsersCount(int usersCount) {
            this.usersCount = usersCount;
        }
    }

}
