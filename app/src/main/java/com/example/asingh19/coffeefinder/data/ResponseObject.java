package com.example.asingh19.coffeefinder.data;
/**
 * Created by asingh19 on 8/24/15.
 */
public class ResponseObject {
    GroupList response;

    public ResponseObject() { }

    public GroupList getResponse() {
        return response;
    }

    public void setResponse(GroupList response) {
        this.response = response;
    }

    public ResponseObject(GroupList response) {
        this.response = response;
    }
}
