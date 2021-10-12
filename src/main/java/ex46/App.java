/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//word class holds a string and how frequent the string appears
class Word
{
    public String word;
    public int quantity;

    public void setWord(String word)
    {
        this.word = word;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public String getWord()
    {
        return word;
    }
    public int getQuantity()
    {
        return quantity;
    }
}

public class App
{
    //reads information from a file to a single string
    public static String readFile(File file) throws FileNotFoundException
    {
        String input = "";
        //scanner can read from a file
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            //add each line to a string seperated by a space
            input += scan.nextLine();
            input += " ";
        }
        return input;
    }

    //prints out each word and asterisks representing how common they are
    public static void printWords(List<Word> words)
    {
        for(int i = 0;i < words.size();i++)
        {
            //prints a word
            System.out.print(String.format("%-10s",words.get(i).getWord()+": "));
            //then checks its quantity to see how many asterisks to print
            for(int j = 0; j < words.get(i).getQuantity();j++)
            {
                System.out.print("*");
            }
            //new line so the next word can be formatted
            System.out.print("\n");
        }
    }

    //sorts the List of words by quantity
    public static List<Word> wordSort(List<Word> words)
    {
        // creates a second arraylist to hold sorted values
        List<Word> sortedWords = new ArrayList<Word>();
        //two integers holding the highest quantity and the index of the with with the highest quantity
        int highestIndex = 0, highestNumber = 0;

        //for every word
        while(words.size() != 0)
        {
            //check to see which word has the highest quantity
            for (int i = 0; i < words.size(); i++)
            {
                if(i == 0)
                {
                    highestNumber = words.get(i).getQuantity();
                    highestIndex = i;
                }
                else if(words.get(i).getQuantity() > highestNumber)
                {
                    highestNumber = words.get(i).getQuantity();
                    highestIndex = i;
                }
            }
            //remove the word with the highest quantity from the original List and pass it into the new List
            sortedWords.add(words.get(highestIndex));
            words.remove(words.get(highestIndex));
        }
        return sortedWords;
    }

    //Turn an array of individual Strings into word objects
    public static List<Word> wordParse(String[] input)
    {
        List<Word> words = new ArrayList<Word>();
        boolean foundWord = false;
        //if the word is already present in the word list up the quantity
        for(int i  = 0; i < input.length;i++)
        {
            foundWord = false;
            for(int j = 0; j < words.size();j++)
            {
                if(input[i].equals(words.get(j).getWord()))
                {
                    foundWord = true;
                    words.get(j).setQuantity(words.get(j).getQuantity()+1);
                }
            }
            //if the word is not found in the list create a new word and add it to the list
            if(!foundWord)
            {
                Word temp = new Word();
                temp.setWord(input[i]);
                temp.setQuantity(1);
                words.add(temp);
            }
        }
        return words;
    }
    public static void main( String[] args ) throws FileNotFoundException {
        //scanner that can read a file
        Scanner scan = new Scanner(System.in);
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        String input = "";
        //input becomes a string containing the whole txt document
        try {
            input = readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Word> words = new ArrayList<Word>();
        //input.split turns the string into an array and stores the created Word list in words
        words = wordParse(input.split(" "));

        //sorts the words list
        words = wordSort(words);

        //and prints out the formatted result
        printWords(words);
    }
}
