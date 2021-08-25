package com.edument.assignment.UploadClient.UploadClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edument.assignment.UploadClient.UploadClient.MultipartUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class UploadClientApplication {
	        
	        public static void main(String[] args) {
	            String charset = "UTF-8";
	            File uploadFile1 = new File("C:/eclipse-workspace/UploadClient/src/main/resources/upload/IMG_5628.jpg");
	            File uploadFile2 = new File("C:/eclipse-workspace/UploadClient/src/main/resources/upload/IMG_5681.jpg");
	            String requestURL = "http://localhost:8081/uploadFile";
	     
	            try {
	                MultipartUtility multipart = new MultipartUtility(requestURL,charset);
	                 
	                multipart.addFilePart("file", uploadFile1);
	                multipart.addFilePart("file", uploadFile2);
	     
	                List<String> response = multipart.finish();
	                 
	                System.out.println("SERVER REPLIED:");
	                 
	                for (String line : response) {
	                    System.out.println(line);
	                }
	            } catch (IOException ex) {
	            	ex.printStackTrace();
	            }
	        }
}
