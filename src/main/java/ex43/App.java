/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    //creates a file at the specified location
    public static void generateFile(String fileName)
    {
        new File(fileName).mkdirs();
        //tells the user a file was made
        System.out.println("Created "+fileName);
    }
    //generates and fills an html file at the specified location
    public static void createHtmlFile(String SiteLocation,String title, String author) throws IOException {
        //creates file
        File html = new File(SiteLocation+"/index.html");
        //allows program to write into the html file
        BufferedWriter bw = new BufferedWriter(new FileWriter(html));
        //writes title and author into html file
        bw.write("<html><head><title>"+title+"</title><meta name=\"author\" content=\""+author+"\"></head></html>");
        bw.close();
        //notifys the user
        System.out.println("Created "+SiteLocation+"/index.html");
    }

    public static void main( String[] args ) throws IOException {
        //stores the location of the file
        String fileRoot = "src/main/java/ex43/website/";
        //scanner for user input
        Scanner scan = new Scanner(System.in);
        //input gathering
        System.out.print("Site name: ");
        String siteName = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("Do you want a folder for JavaScript? (y/n) ");
        String javaScript = scan.nextLine();
        System.out.print("Do you want a folder for CSS? (y/n) ");
        String CSS = scan.nextLine();

        //creates a folder with the website name
        generateFile(fileRoot+siteName);

        //creates a html file in the website folder
        createHtmlFile(fileRoot+siteName,siteName,author);

        //generates additional files according to user input
        if(javaScript.toLowerCase().equals("y"))
        {
            generateFile(fileRoot+siteName+"/js/");
        }
        if(CSS.toLowerCase().equals("y"))
        {
            generateFile(fileRoot+siteName+"/css/");
        }
    }
}
