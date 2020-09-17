/*
Martino Caldarella
44989955
mcaldare@uci.edu
UCI EECS 40 Spring 2018
Assignment 1
 */



import java.io.*;
import java.lang.*;
import java.util.*;

public class Certifications {

    private Scanner certIn;
    int nCertifications;
    private String[] certifications = new String[10];
    private String[] title = new String[10];
    private String[] date = new String[10];



    public void getCertifications() {
        try {
            certIn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        System.out.println("Reading certifications...");

        int i = 0;
        while (certIn.hasNext()) {
            certifications[i] = certIn.nextLine();
            if (certifications[i].contains("Certification") ||
                    certifications[i].contains("Honor") ||
                    certifications[i].contains("Award") ||
                    certifications[i].contains("Best")) {
                nCertifications++;
                String[] tokens = certifications[i].split(", ");
                title[i] = tokens[0];
                date[i] = tokens[1];
                i++;
            }
        }
    }

    public String setCertifications(){
        StringBuffer sb = new StringBuffer();
        String certifications = new String();

        for(int i = 0; i < nCertifications; i++){
            if(date[i].equals(date[i+1])){
                certifications = sb.append(date[i] + "\n" + title[i] + "\n").toString();
                while(date[i].equals(date[i+1])) {
                    certifications = sb.append(title[i+1] + "\n").toString();
                    i++;
                }
            }
            else{
                certifications = sb.append(date[i] + "\n" + title[i] + "\n").toString();
            }
        }
        return certifications;
    }



}
