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
    //reads a file into a single string
    public static String readFile(File file) throws FileNotFoundException
    {
        //creating the variable to hold the strings
        String input = "";
        //this scanner can read input from a text file
        Scanner scan = new Scanner(file);

        //while there is still a next line add the line to a String
        while(scan.hasNextLine())
        {
            input += scan.nextLine();

            //if the line is not the last line add a new line charachter
            if(scan.hasNextLine()) {
                input += "\n";
            }
        }
        return input;
    }

    //use the .replaceAll function of a string to replace words in the string
    public static String replaceWord(String input, String find, String replace)
    {
        return input.replaceAll(find,replace);
    }

    //creates a file and fills it with the output string
    public static void createFile(String fileName, String output) throws FileNotFoundException {
        //creates the file with user inputed name
        File outfile = new File(fileName+".txt");
        //sets output to the file
        PrintStream stream = new PrintStream(outfile);
        System.setOut(stream);
        //prints output
        System.out.print(String.format(output));
    }
    public static void main( String[] args ) throws FileNotFoundException {
        //scanner for user input
        Scanner scan = new Scanner(System.in);
        //String and file holding the file location
        String fileRoot = "src/main/java/ex45/";
        File file = new File("src/main/java/ex45/exercise45_input.txt");
        String input = "";
        String output ="";
        try {
            //input will read in the txt file
            input = readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //output will gain the replaced version of the input string
        output = replaceWord(input,"utilize","use");

        //prompt for user inputed file name
        System.out.print("What do you want to name the output file? (do not put .txt) ");
        String fileName = scan.nextLine();

        //push the output to a user named file
        createFile(fileRoot+fileName,output);
    }
}
