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

public class Academics {

    private Scanner acadIn;
    private String[] schools = new String[10];
    private int[] nCourses = new int[10];
    private float[] GPA = new float[10];
    private String[][] course = new String[10][10];
    private String[][] courseName = new String[10][10];
    private float[][] courseScore = new float[10][10];
    private int i;

    public void getAcademics() {
        try {
            acadIn = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        System.out.println("Reading academics...");

        i = 0;

        while (acadIn.hasNext()) {
            schools[i] = acadIn.nextLine();
            if (schools[i].contains("University") || schools[i].contains("College") || schools[i].contains("School")) {
                nCourses[i] = Integer.parseInt(acadIn.nextLine());
                for (int k = 0; k < nCourses[i]; k++) {
                    course[k][i] = acadIn.nextLine();
                    String[] tokens = course[k][i].split(", ");
                    courseName[k][i] = tokens[0];
                    courseScore[k][i] = Float.parseFloat(tokens[1]);
                    GPA[i] = GPA[i] + courseScore[k][i];
                }
                GPA[i] = GPA[i] / nCourses[i];
                i++;
            }
        }
    }

    public String setAcademics(){


        StringBuffer sb = new StringBuffer();
        String academics = new String();

        for(int j = 0; j < i; j++) {
            academics = sb.append(String.format("%-35s",schools[j]) + "GPA:" + String.format("%.1f", GPA[j]) + "\n\n").toString();
            for(int k = 0; k < nCourses[j]; k++) {
                if (k == nCourses[j] - 1){
                    academics = sb.append("-" + String.format("%-30s",courseName[k][j]) + "\t" + gradeCalculator(courseScore[k][j]) + "\n\n").toString();
                }
                else{
                    academics = sb.append("-" + String.format("%-30s",courseName[k][j]) + "\t" + gradeCalculator(courseScore[k][j]) + "\n").toString();
                }
            }
        }

        return academics;

    }

    public String gradeCalculator(float score){

        String grade = "";

        if(score == 4.0){
            grade = "A+";
        }
        else if(score >= 3.7 && score < 4.0){
            grade = "A";
        }
        else if(score >= 3.7 && score < 4.0){
            grade = "A-";
        }
        else if(score >= 3.3 && score < 3.7){
            grade = "B+";
        }
        else if(score >= 3.0 && score < 3.3){
            grade = "B";
        }
        else if(score >= 2.7 && score < 3.0){
            grade = "B-";
        }
        else if(score >= 2.3 && score < 2.7){
            grade = "C+";
        }
        else if(score >= 2.0 && score < 2.3){
            grade = "C";
        }
        else if(score >= 1.7 && score < 2.0) {
            grade = "C-";
        }
        else if(score >= 1.3 && score < 1.7){
            grade = "D+";
        }
        else if(score >= 1.0 && score < 1.3){
            grade = "D";
        }
        else if(score <= 1.0) {
            grade = "F";
        }
        return grade;
    }




}
