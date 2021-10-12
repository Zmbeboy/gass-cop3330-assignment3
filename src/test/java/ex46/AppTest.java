/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readFile() throws FileNotFoundException {
        String testResult = "badger badger badger badger mushroom mushroom snake badger badger badger ";
        App test = new App();
        File file = new File("src/test/java/ex46/exercise46_inputTest.txt");

        assertEquals(test.readFile(file),testResult);
    }

    @Test
    void wordSort()
    {
        String testResult = "badger badger badger badger mushroom mushroom snake badger badger badger test test test";
        App test = new App();
        List<Word> words = new ArrayList<Word>();
        words = test.wordParse(testResult.split(" "));
        words = test.wordSort(words);

        assertEquals(7,words.get(0).getQuantity());
        assertEquals(3,words.get(1).getQuantity());
        assertEquals(2,words.get(2).getQuantity());
        assertEquals(1,words.get(3).getQuantity());
    }

    @Test
    void wordParse()
    {
        String testResult = "badger badger badger badger mushroom mushroom snake badger badger badger test test test";
        App test = new App();
        List<Word> words = new ArrayList<Word>();
        words = test.wordParse(testResult.split(" "));

        assertEquals(7,words.get(0).getQuantity());
        assertEquals(2,words.get(1).getQuantity());
        assertEquals(1,words.get(2).getQuantity());
        assertEquals(3,words.get(3).getQuantity());


    }
}