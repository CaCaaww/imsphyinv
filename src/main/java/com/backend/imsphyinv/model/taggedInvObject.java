package com.backend.imsphyinv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//serial, scandata, username, location
public class taggedInvObject {
    private String serial;
    private String scandate;
    private String username;
    private String location;

    public taggedInvObject(){

    }
    public taggedInvObject(String serial, String scandate, String username, String location){
        this.serial = serial;
        this.scandate = scandate;
        this.username = username;
        this.location = location;
    }

    @JsonProperty("serial")
    public String getSerial(){
        return serial;
    }
    @JsonProperty("scandate")
    public String getScandata(){
        return scandate;
    }
    @JsonProperty("username")
    public String getUsername(){
        return username;
    }
    @JsonProperty("location")
    public String getLocation(){
        return location;
    }

    @JsonProperty("serial")
    public void setSerial(String serial){
        this.serial = serial;
    }
    @JsonProperty("scandate")
    public void setScandata(String scandate){
        this.scandate = scandate;
    }
    @JsonProperty("username")
    public void setUsername(String username){
        this.username = username;
    }
    @JsonProperty("location")
    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString(){
        return "taggedInvObject[serial=" + serial + ", scandate=" + scandate + ", username=" + username + ", location=" + location + "]";
    }
}
