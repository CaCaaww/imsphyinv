package com.backend.imsphyinv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//part, qty, uom, scandate, user, location
public class untaggedInvObject {
    @JsonProperty("part") private String part;
    @JsonProperty("qty") private int qty;
    @JsonProperty("uom") private String uom;
    @JsonProperty("scandate") private String scandate;
    @JsonProperty("username") private String user;
    @JsonProperty("location") private String location;

    public untaggedInvObject(){

    }
    public untaggedInvObject(@JsonProperty("part") String part, @JsonProperty("qty") int qty, @JsonProperty("uom") String uom, @JsonProperty("scandate") String scandate, @JsonProperty("username") String user, @JsonProperty("location") String location){
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
    @JsonProperty("username")
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
    @JsonProperty("username")
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

    public String getDate(){
        String[] monthDayYear = {"", "", ""};
        int count = 0;
        for(int i = 0; i< scandate.length(); i++){
            String sub = scandate.substring(i, i+1);
            if (sub.equals("/")){
                count++;
            } else if(sub.equals(" ") && count ==2){
                break;
            } else {
                monthDayYear[count] += sub;
            }

        }
        for (int i = 0; i < monthDayYear.length; i++){
            if (monthDayYear[i].length() == 1){
                monthDayYear[i] = "0" + monthDayYear[i];
            }
        }
        return monthDayYear[2] + '-' + monthDayYear[0] + '-' + monthDayYear[1];

    }

    public String getTime(){
        String[] hourMinSec = {"","", ""};
        Boolean isPM = false;
        int count = 0;
        for (int i = scandate.indexOf(" ") + 1; i < scandate.length(); i++){
            String sub = scandate.substring(i, i+1);
            if (sub.equals(":")){
                count ++;
            } else if (sub.equals(" ")){
                if (scandate.substring(i+1, i+3).equals("PM")){
                    isPM = true;
                }
                break;
            } else {
                hourMinSec[count] += sub;
            }
        }
        if (isPM){
            hourMinSec[0] = (Integer.parseInt(hourMinSec[0]) + 12) + "";
        }
        for (int i = 0; i < hourMinSec.length; i++){
            if (hourMinSec[i].length() == 1){
                hourMinSec[i] = "0" + hourMinSec[i];
            }
        }
        return hourMinSec[0] + ":" + hourMinSec[1] + ":" + hourMinSec[2];
    }
}
