package com.backend.imsphyinv.persistence;


import com.backend.imsphyinv.model.partlist;
import com.backend.imsphyinv.model.seriallist;

public interface phyinvDao {


    void createNewSerialList(seriallist serialList);

    void createNewPartList(partlist partList);




}