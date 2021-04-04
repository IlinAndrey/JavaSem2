package com.example.task12;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileConstructor {
    String inputPath = "C:/Users/User/IdeaProjects/JavaVUZ/Number12/input.txt";
    String outputPath = "C:/Users/User/IdeaProjects/JavaVUZ/Number12/output.txt";

    private File file;


    @PostConstruct
    private void construct() {
        System.out.println("PostConstruct method activated!");
        try {
            file = new File(inputPath);
            if (!file.exists()) {
                writeToFile(outputPath, "Ничего нет");
                return;
            }
            String text = readFromFile(inputPath);
            String data = hashedData(text);
            writeToFile(outputPath, data);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("PreDestroy method activated!");
        if (file.delete()){
            System.out.println("File deleted");
        } else {
            System.out.println("Error");
        }
    }

    private void writeToFile(String path, String text) throws IOException {
        System.out.println("Writing text to file...");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(String path){
        System.out.println("Read from file");
        StringBuilder stringBuilder = new StringBuilder();
        try{
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String hashedData(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = messageDigest.digest(
                data.getBytes(StandardCharsets.UTF_8)
        );
        return bytesToHex(encodedhash);
    }
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    }





