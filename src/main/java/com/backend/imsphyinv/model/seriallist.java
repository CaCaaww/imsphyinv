package com.backend.imsphyinv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class seriallist {
    private taggedInvObject[] SerialList;

    public seriallist(){

    }
    public seriallist(taggedInvObject[] SerialList){
        this.SerialList = SerialList;
    }

    @JsonProperty("SerialList")
    public taggedInvObject[] getSeriallist(){
        return SerialList;
    }

    @JsonProperty("SerialList")
    public void setSeriallist(taggedInvObject[] SerialList){
        this.SerialList = SerialList;
    }

    @Override
    public String toString(){
        String listOfSerials = "";
        for (taggedInvObject obj : SerialList){
            listOfSerials += obj.toString() + ", ";
        }
        listOfSerials = listOfSerials.substring(0, listOfSerials.length() -2);
        return "seriallist[SerialList=[" + listOfSerials +"]]";
    }

}