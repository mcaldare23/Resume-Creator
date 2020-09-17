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

public class Info {

    private Scanner infoIn;
    private String fName = new String();
    private String lName = new String();
    private String phone = new String();
    private String email = new String();


    public void getInfo() {
        try {
            infoIn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        System.out.println("Reading info...");

        fName = infoIn.next();
        lName = infoIn.next();
        phone = infoIn.next();
        email = infoIn.next();
    }
    public String setInfo(){
        StringBuffer sb = new StringBuffer();
        String info;

        info = sb.append("Name:\t" + fName + " " + lName + "\n" +
                "Phone:\t" + phone + "\n" +
                "email:\t" + email + "\n\n").toString();
        info = info.replace(',',' ');
        return info;


    }



}
