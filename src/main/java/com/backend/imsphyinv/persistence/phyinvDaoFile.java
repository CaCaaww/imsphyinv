package com.backend.imsphyinv.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.backend.imsphyinv.model.partlist;
import com.backend.imsphyinv.model.seriallist;
import com.backend.imsphyinv.model.taggedInvObject;
import com.backend.imsphyinv.model.untaggedInvObject;



@Component
public class phyinvDaoFile implements phyinvDao{
    


    

    private String FOLDER_PATH;

    public phyinvDaoFile(@Value("${outputFolder.path}") String FOLDER_PATH){
        this.FOLDER_PATH = FOLDER_PATH;
    }

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

    
    
    private File initializeCsvFile(){
        System.out.println("FOLDER_PATH:" + FOLDER_PATH);
        //C:\\Users\\jhansplant\\imsphyinv\\output\\
        File file = new File(FOLDER_PATH + "output.csv");
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
