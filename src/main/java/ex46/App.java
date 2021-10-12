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
    public static String readFile(File file) throws FileNotFoundException
    {
        String input = "";
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            input += scan.nextLine();
            input += " ";
        }
        return input;
    }

    public static void printWords(List<Word> words)
    {
        for(int i = 0;i < words.size();i++)
        {
            System.out.print(String.format("%-10s",words.get(i).getWord()+": "));
            for(int j = 0; j < words.get(i).getQuantity();j++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static List<Word> wordSort(List<Word> words)
    {
        List<Word> sortedWords = new ArrayList<Word>();
        int highestIndex = 0, highestNumber = 0;

        while(words.size() != 0)
        {
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
            sortedWords.add(words.get(highestIndex));
            words.remove(words.get(highestIndex));
        }
        return sortedWords;
    }

    public static List<Word> wordParse(String[] input)
    {
        List<Word> words = new ArrayList<Word>();
        boolean foundWord = false;
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
        Scanner scan = new Scanner(System.in);
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        String input = "";
        try {
            input = readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Word> words = new ArrayList<Word>();
        words = wordParse(input.split(" "));

        words = wordSort(words);

        printWords(words);
    }
}
