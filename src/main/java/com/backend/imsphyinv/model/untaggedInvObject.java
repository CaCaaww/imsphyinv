package com.backend.imsphyinv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//part, qty, uom, scandate, user, location
public class untaggedInvObject {
    private String part;
    private int qty;
    private String uom;
    private String scandate;
    private String user;
    private String location;

    public untaggedInvObject(){

    }
    public untaggedInvObject(String part, int qty, String uom, String scandate, String user, String location){
        this.part = part;
        this.qty = qty;
        this.uom = uom;
        this.scandate = scandate;
        this.user = user;
        this.location = location;
    }

    @JsonProperty("part")
    public String getPart(){
        return part;
    }
    @JsonProperty("qty")
    public int getQty(){
        return qty;
    }
    @JsonProperty("uom")
    public String getUom(){
        return uom;
    }
    @JsonProperty("scandate")
    public String getScandate(){
        return scandate;
    }
    @JsonProperty("user")
    public String getUser(){
        return user;
    }
    @JsonProperty("location")
    public String getLocation(){
        return location;
    }

    @JsonProperty("part")
    public void setPart(String part){
        this.part = part;
    }
    @JsonProperty("qty")
    public void setQty(int qty){
        this.qty = qty;
    }
    @JsonProperty("uom")
    public void setUom(String uom){
        this.uom = uom;
    }
    @JsonProperty("scandate")
    public void setScandate(String scandate){
        this.scandate = scandate;
    }
    @JsonProperty("user")
    public void setUser(String user){
        this.user = user;
    }
    @JsonProperty("location")
    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString(){
        return "untaggedInvObject[part=" + part + ", qty=" + qty + ", uom=" + uom + ", scandate=" + scandate + ", user=" + user + ", location=" + location + "]";
    }
}
