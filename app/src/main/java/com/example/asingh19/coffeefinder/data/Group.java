package com.example.asingh19.coffeefinder.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asingh19 on 8/24/15.
 */
public class Group {
    String type;
    String name;
    @SerializedName("items")
    List<Item> items;

    public Group(String type, String name, List<Item> items) {
        this.type = type;
        this.name = name;
        this.items = items;
    }
    public Group() {

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
