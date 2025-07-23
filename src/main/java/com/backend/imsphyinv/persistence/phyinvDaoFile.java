package com.backend.imsphyinv.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.backend.imsphyinv.model.partlist;
import com.backend.imsphyinv.model.seriallist;
import com.backend.imsphyinv.model.taggedInvObject;
import com.backend.imsphyinv.model.untaggedInvObject;



@Component
public class phyinvDaoFile implements phyinvDao{  

    private static final Logger LOG = Logger.getLogger(phyinvDaoFile.class.getName());
    private String FOLDER_PATH_FOLDER;
    private String FOLDER_PATH;
    
    public phyinvDaoFile(@Value("${outputFolder.path}") String FOLDER_PATH){
        this.FOLDER_PATH_FOLDER = FOLDER_PATH;
        // LOG.info("FOLDER PATH: " + FOLDER_PATH);
        this.FOLDER_PATH = "C:\\Users\\jhansplant\\imsphyinv\\output\\";
    }
    private void SetFolderPath(){
        try {
            Path path = Path.of(FOLDER_PATH_FOLDER);
            String str = Files.readString(path);

            // Printing the string
            System.out.println(str);
            FOLDER_PATH = str;
        } catch (Exception e) {
            System.out.println("error reading file location");
            e.printStackTrace();
        }
    }

    @Override
    public void createNewSerialList(seriallist serialList){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = LocalDate.now().format(formatter);

        FileWriter file = initializeCsvFile("scantags_" + date + ".csv","serial,scandate,scantime,username,location");
        try (BufferedWriter bw = new BufferedWriter(file)) {
            for(taggedInvObject obj : serialList.getSeriallist()){
                bw.append(obj.getSerial() + "," + obj.getDate() + "," + obj.getTime() + "," + obj.getUsername() + "," + obj.getLocation() + "\n");
            }
        } catch (Exception e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }
        FileWriter file2 = initializeCsvFile("tags.dat", null);
        try (BufferedWriter bw = new BufferedWriter(file2)){
            for(taggedInvObject obj : serialList.getSeriallist()){
                bw.append(obj.getSerial() + "\n");
            }
        } catch (Exception e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }
        
    }

    @Override
    public void createNewPartList(partlist partList){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = LocalDate.now().format(formatter);

        FileWriter file = initializeCsvFile("scannontags_" + date + ".csv","part,qty,uom,scandate,scantime,username,location");
        try (BufferedWriter bw = new BufferedWriter(file)){
            ;
            for(untaggedInvObject obj : partList.getPartlist()){ 
                bw.append(obj.getPart() + "," + obj.getQty() + "," + obj.getUom() + "," + obj.getDate() + "," + obj.getTime() + "," + obj.getUser() + "," + obj.getLocation() + "\n");
            } 
        } catch (Exception e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }

        FileWriter file2 = initializeCsvFile("nontags.dat",null);
        try (BufferedWriter bw = new BufferedWriter(file2)) {
            for(untaggedInvObject obj : partList.getPartlist()){
                bw.append(obj.toString() + "\n");
            }
            
        } catch (Exception e){
            System.out.println("error writing to file");
            e.printStackTrace();
        }
    }

    
    
    private FileWriter initializeCsvFile(String name ,String header){
        SetFolderPath();
        //C:\\Users\\jhansplant\\imsphyinv\\output\\
        File file = new File(FOLDER_PATH + name);
        try {
            if (!file.exists()) {
                FileWriter file2 = new FileWriter(FOLDER_PATH + name);
                // file.createNewFile();
                BufferedWriter bw = new BufferedWriter(file2);
                if (header != null){
                    bw.write(header + "\n");
                }
                bw.close();
                return file2;
            } else {
                FileWriter file2 = new FileWriter(FOLDER_PATH + name, true);
                return file2;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating CSV file", e);
        }
        
    }
    


}
