package com.example.asingh19.coffeefinder.data;

import java.util.List;

/**
 * Created by asingh19 on 8/24/15.
 */
public class GroupList {
    List<Group> groups;
    public GroupList() { }
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    public GroupList(List<Group> groups) {
        this.groups = groups;
    }
}
