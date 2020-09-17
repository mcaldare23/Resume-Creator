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

public class Researches {

    private Scanner resIn;
    private int nResearches;
    private String[] researches = new String[10];
    private String[] title = new String[10];
    private String[] date = new String[10];



    public void getResearches() {
        try {
            resIn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        System.out.println("Reading researches...");

        int i = 0;
        while (resIn.hasNext()) {
            researches[i] = resIn.nextLine();
            if (researches[i].contains("Research") ||
                    researches[i].contains("Analysis") ||
                    researches[i].contains("Investigation") ||
                    researches[i].contains("Paper")) {
                nResearches++;
                String[] tokens = researches[i].split(", ");
                title[i] = tokens[0];
                date[i] = tokens[1];
                i++;
            }
        }
    }

    public String setResearches(){
        StringBuffer sb = new StringBuffer();
        String researches = new String();

        for(int i = 0; i < nResearches; i++){
            researches = sb.append(date[i] + "\n" + title[i] + "\n").toString();
        }
        return researches;

    }



}
