/*
Martino Caldarella
44989955
mcaldare@uci.edu
UCI EECS 40 Spring 2018
Assignment 1
 */



import java.io.*;

public class CVwriter {
    public static void write(String s, File f) throws IOException{
        FileWriter fw = new FileWriter(f, true);
        fw.write(s);
        fw.close();
    }
    public static void main(String[] args){
        try{
            File f = new File("output.txt");

            write("\tCURRICULUM VITAE\n\n", f);

            Info i = new Info();
            i.getInfo();
            write(i.setInfo(), f);

            write("\n\nACADEMIC\n\n", f);

            Academics a = new Academics();
            a.getAcademics();
            write(a.setAcademics(), f);

            write("\n\nRESEARCHES\n\n", f);

            Researches r = new Researches();
            r.getResearches();
            write(r.setResearches(), f);

            write("\n\nPROJECTS\n\n", f);

            Projects p = new Projects();
            p.getProjects();
            write(p.setProjects(), f);

            write("\n\nCERTIFICATIONS\n\n", f);

            Certifications c = new Certifications();
            c.getCertifications();
            write(c.setCertifications(), f);
        }
        catch(IOException e){
            System.out.println("Error while writing");
        }
    }
}