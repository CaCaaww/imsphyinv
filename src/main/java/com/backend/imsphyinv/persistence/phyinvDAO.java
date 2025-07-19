package com.backend.imsphyinv.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.backend.imsphyinv.model.partlist;
import com.backend.imsphyinv.model.seriallist;
import com.backend.imsphyinv.model.taggedInvObject;
import com.backend.imsphyinv.model.untaggedInvObject;

public class phyinvDAO {
    


    public void createNewSerialList(seriallist serialList){
        File file = initializeCsvFile();
        try (PrintWriter pw = new PrintWriter(file)) {

            for(taggedInvObject obj : serialList.getSeriallist()){
                pw.write(obj.toString() + "\n");
            }
            

        } catch (FileNotFoundException e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }
        
    }

    public void createNewPartList(partlist partList){
        File file = initializeCsvFile();
        try (PrintWriter pw = new PrintWriter(file)) {

            for(untaggedInvObject obj : partList.getPartlist()){
                pw.write(obj.toString() + "\n");
            }
            
        } catch (FileNotFoundException e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }
    }

    

    private File initializeCsvFile()
    {
        File file = new File("C:\\Users\\jhansplant\\imsphyinv\\output\\output.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            }
            catch (Exception e) {
                throw new RuntimeException(
                    "Error creating CSV file", e);
            }
        }
        return file;
    }
}
