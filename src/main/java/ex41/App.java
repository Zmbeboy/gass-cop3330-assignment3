/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex41;
import java.io.*;
import java.nio.file.Path;
import java.util.*;


public class App
{
    //readFile takes in a File object and converts it into a list of strings for each line of the text document
    public static List<String> readFile(File file) throws FileNotFoundException {
        //creating the variable to hold the strings
        List<String> Names = new ArrayList<String>();
        //this scanner can read input from a text file
        Scanner scan = new Scanner(file);

        //while there is still a next line add the line to a list
        while(scan.hasNextLine())
        {
            Names.add(scan.nextLine());
        }
        return Names;
    }

    //uses the collections.sort function to sort a list
    public static List<String> sortArrayList(List<String> names)
    {
        Collections.sort(names);
        return names;
    }

    //prints the List of strings out to a file
    public static void printToFile(List<String> names) throws FileNotFoundException {
        //creates the output file
        File output = new File("src/main/java/ex41/exercise41_output.txt");
        //sets the output to a file rather than a console
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        //formatting the response
        System.out.println(String.format("Total of %d names\n-----------------",names.size()));

        //printing each person
        for(int i = 0; i < names.size();i++)
        {
            System.out.println(names.get(i));
        }

    }
    public static void main(String[] args)
    {
        //finds the input file
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        //creates a blank list of strings
        List<String> names = new ArrayList<String>();
        try {
            //fills the list with the txt file
            names = readFile(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //sorts the list
        names = sortArrayList(names);

        try {
            //prints the list formatted
            printToFile(names);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
