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

public class Projects {

    private Scanner projIn;
    int nProjects;
    private String[] projects = new String[10];
    private String[] title = new String[10];
    private String[] date = new String[10];



    public void getProjects() {
        try {
            projIn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        System.out.println("Reading projects...");

        int i = 0;
        while (projIn.hasNext()) {
            projects[i] = projIn.nextLine();
            if (projects[i].contains("Project")) {
                nProjects++;
                String[] tokens = projects[i].split(", ");
                title[i] = tokens[0];
                date[i] = tokens[1];
                i++;
            }
        }


    }
    public String setProjects(){
        StringBuffer sb = new StringBuffer();
        String projects = new String();

        for (int i = 0; i < nProjects; i++) {
            projects = sb.append(date[i] + "\n" + title[i] + "\n").toString();
        }
        return projects;
    }



}
