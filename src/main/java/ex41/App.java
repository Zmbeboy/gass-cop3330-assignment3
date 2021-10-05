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
    public static List<String> readFile(File file) throws FileNotFoundException {
        List<String> Names = new ArrayList<String>();
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            Names.add(scan.nextLine());
        }
        return Names;
    }

    public static List<String> sortArrayList(List<String> names)
    {
        Collections.sort(names);
        return names;
    }

    public static void printToFile(List<String> names) throws FileNotFoundException {
        File output = new File("src/main/java/ex41/exercise41_output.txt");
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        System.out.println(String.format("Total of %d names\n-----------------",names.size()));

        for(int i = 0; i < names.size();i++)
        {
            System.out.println(names.get(i));
        }

    }
    public static void main( String[] args )
    {
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        List<String> names = new ArrayList<String>();
        try {
            names = readFile(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        names = sortArrayList(names);

        try {
            printToFile(names);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
