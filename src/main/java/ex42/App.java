/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex42;
import java.io.*;
import java.util.*;

//Employee class holds information about an employee and contains instructions on how to output it
class Employee
{
    //information
    public String FirstName;
    public String LastName;
    public int salary;

    //how to output the information
    public void printEmployees()
    {
        System.out.println(String.format("%-9s %-9s %d",LastName,FirstName,salary));
    }
}

public class App
{
    //splits the data from a string into an employee object
    public static Employee parseData(String data)
    {
        //creates an employee and a temp string
        Employee em = new Employee();
        String temp = "";

        int j = 0;
        for(int i = 0; i < data.length(); i++)
        {
            //if the charachter is not a comma add it to the temp string
            if(data.charAt(i)!= ',')
            {
                temp += data.charAt(i);
            }
            //at a comma cut off the temp string and store it in either lastname firstname or the salary
            else
            {
                //j decides where the temp string is stored
                if(j == 0)
                {
                    em.LastName = temp;
                    temp = "";
                    j++;
                }
                else if(j==1)
                {
                    em.FirstName = temp;
                    temp = "";
                }
            }
        }
        em.salary = Integer.parseInt(temp);
        temp = null;

        //return the employee
        return em;
    }

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

    public static void main( String[] args )
    {
        //Finds the input file
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        List<String> input = new ArrayList<String>();
        List<Employee> employees = new ArrayList<Employee>();
        try
        {
            //reads in the input file into a list of strings
            input = readFile(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //converts the list of strings into a list of employees
        for(int i = 0; i < input.size();i++)
        {
            employees.add(parseData(input.get(i)));
        }
        //formatting for the output
        System.out.println("Last      First     Salary\n--------------------------");
        //prints the employees data
        for(int i = 0; i < employees.size();i++)
        {
            employees.get(i).printEmployees();
        }

    }
}
