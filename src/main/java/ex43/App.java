/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex43;

import javax.swing.text.Document;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void generateFile(String fileName)
    {
        new File(fileName).mkdirs();
        System.out.println("Created "+fileName);
    }
    public static void createHtmlFile(String title, String author) throws IOException {
        File html = new File("src/main/java/ex43/website/"+title+"/index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(html));
        bw.write("<html><head><title>"+title+"</title><meta name=\"author\" content=\""+author+"\"></head></html>");
        bw.close();
        System.out.println("Created src/main/java/ex43/website/"+title+"/index.html");
    }
    public static void main( String[] args ) throws IOException {
        String fileRoot = "src/main/java/ex43/website/";
        Scanner scan = new Scanner(System.in);
        System.out.print("Site name: ");
        String siteName = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("Do you want a folder for JavaScript? (y/n) ");
        String javaScript = scan.nextLine();
        System.out.print("Do you want a folder for CSS? (y/n) ");
        String CSS = scan.nextLine();

        generateFile(fileRoot+siteName);



        createHtmlFile(siteName,author);

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
