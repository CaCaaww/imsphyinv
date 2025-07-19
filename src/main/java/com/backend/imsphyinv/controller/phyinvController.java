package com.backend.imsphyinv.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.imsphyinv.model.partlist;
import com.backend.imsphyinv.model.seriallist;
import com.backend.imsphyinv.model.taggedInvObject;
import com.backend.imsphyinv.model.untaggedInvObject;
import com.backend.imsphyinv.persistence.phyinvDAO;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@CrossOrigin("http://192.168.12.31:9080")
@RequestMapping("/IMSPhyInv")
public class phyinvController {
    private static final Logger LOG = Logger.getLogger(phyinvController.class.getName());
    private phyinvDAO phyinvDao;

    public phyinvController(){
        phyinvDao = new phyinvDAO();
    }


    @GetMapping("")
    public ResponseEntity<String> getAllData(){
        LOG.info("GET /imsphyinv");
        try {
            return new ResponseEntity<String>("REQUEST WORKS", HttpStatus.OK);
        } catch (Exception e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/ScannedSerials")
    public ResponseEntity<seriallist> createScannedSerials(@RequestBody seriallist list){
        LOG.info("POST /scannedSerial " + list);
        try {
            phyinvDao.createNewSerialList(list);
            return new ResponseEntity<seriallist>(list, HttpStatus.OK);
        } catch (Exception e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ScannedParts")
    public ResponseEntity<partlist> createScannedParts(@RequestBody partlist list){
        LOG.info("POST /scannedParts " + list);
        try {
            phyinvDao.createNewPartList(list);
            return new ResponseEntity<partlist>(list, HttpStatus.OK);
        } catch (Exception e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
