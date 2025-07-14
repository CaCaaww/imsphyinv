package com.backend.imsphyinv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.imsphyinv.model.phyInv;
import com.backend.imsphyinv.persistence.phyinvDAO;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@CrossOrigin("http://192.168.12.31:9080")
@RequestMapping("/service/imsphyinv")
public class phyinvController {
    private static final Logger LOG = Logger.getLogger(phyinvController.class.getName());
    private phyinvDAO phyinvDao;

    public phyinvController(){
        
    }


    @PostMapping("/ScannedSerials")
    public ResponseEntity<String> createScannedSerials(@RequestBody String string){
        LOG.info("/scannedSerial" + string);
        try {
            return new ResponseEntity<String>("hotdog", HttpStatus.OK);
        } catch (Exception e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ScannedParts")
    public ResponseEntity<String> createScannedParts(@RequestBody String string){
        LOG.info("/scannedSerial" + string);
        try {
            return new ResponseEntity<String>("hotdog", HttpStatus.OK);
        } catch (Exception e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
