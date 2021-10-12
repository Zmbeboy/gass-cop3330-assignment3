/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class App
{
    public static String readFile(File file) throws FileNotFoundException
    {
        String input = "";
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            input += scan.nextLine();
            if(scan.hasNextLine()) {
                input += "\n";
            }
        }
        return input;
    }

    public static String replaceWord(String input, String find, String replace)
    {
        return input.replaceAll(find,replace);
    }

    public static void createFile(String fileName, String output) throws FileNotFoundException {
        File outfile = new File(fileName+".txt");
        PrintStream stream = new PrintStream(outfile);
        System.setOut(stream);
        System.out.print(String.format(output));
    }
    public static void main( String[] args ) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileRoot = "src/main/java/ex45/";
        File file = new File("src/main/java/ex45/exercise45_input.txt");
        String input = "";
        String output ="";
        try {
            input = readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        output = replaceWord(input,"utilize","use");

        System.out.print("What do you want to name the output file? (do not put .txt) ");
        String fileName = scan.nextLine();

       createFile(fileRoot+fileName,output);
    }
}
