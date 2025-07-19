package com.backend.imsphyinv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class partlist {
    @JsonProperty("PartList") private untaggedInvObject[] PartList;

    public partlist(){

    }
    public partlist(@JsonProperty("PartList") untaggedInvObject[] PartList){
        this.PartList = PartList;
    }

    @JsonProperty("PartList")
    public untaggedInvObject[] getPartlist(){
        return PartList;
    }

    @JsonProperty("PartList")
    public void setPartlist(untaggedInvObject[] PartList){
        this.PartList = PartList;
    }

    @Override
    public String toString(){
        String listOfParts = "";
        for (untaggedInvObject obj : PartList){
            listOfParts += obj.toString() + ", ";
        }
        listOfParts = listOfParts.substring(0, listOfParts.length() -2);
        return "partlist[PartList=[" + listOfParts +"]]";
    }

}
