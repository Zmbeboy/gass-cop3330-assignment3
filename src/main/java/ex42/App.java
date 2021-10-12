/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex42;
import java.io.*;
import java.util.*;

class Employee
{
    public String FirstName;
    public String LastName;
    public int salary;

    public void printEmployees()
    {
        System.out.println(String.format("%-9s %-9s %d",LastName,FirstName,salary));
    }
}

public class App
{
    public static Employee parseData(String data)
    {
        Employee em = new Employee();
        String temp = "";

        int j = 0;
        for(int i = 0; i < data.length(); i++)
        {
            if(data.charAt(i)!= ',')
            {
                temp += data.charAt(i);
            }
            else
            {
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

        return em;
    }

    public static List<String> readFile(File file) throws FileNotFoundException {
        List<String> Names = new ArrayList<String>();
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            Names.add(scan.nextLine());
        }
        return Names;
    }

    public static void main( String[] args )
    {
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        List<String> input = new ArrayList<String>();
        List<Employee> employees = new ArrayList<Employee>();
        try
        {
            input = readFile(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        for(int i = 0; i < input.size();i++)
        {
            employees.add(parseData(input.get(i)));
        }
        System.out.println("Last      First     Salary\n--------------------------");
        for(int i = 0; i < employees.size();i++)
        {
            employees.get(i).printEmployees();
        }

    }
}
