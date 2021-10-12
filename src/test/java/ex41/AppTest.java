/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex41;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest
{

    @Test
    void readFile() throws FileNotFoundException {
        App test = new App();
        File file = new File("src/test/java/ex41/exercise41_inputTest.txt");
        List<String> Names = new ArrayList<String>();
        Names.add("Ling, Mai");
        Names.add("Johnson, Jim");
        Names.add("Zarnecki, Sabrina");
        Names.add("Jones, Chris");
        Names.add("Jones, Aaron");
        Names.add("Swift, Geoffrey");
        Names.add("Xiong, Fong");

        List<String> input = test.readFile(file);

        assertArrayEquals(input.toArray(),Names.toArray());
    }

    @Test
    void sortArrayList() throws FileNotFoundException {
        App test = new App();
        File file = new File("src/test/java/ex41/exercise41_inputTest.txt");
        List<String> Names = new ArrayList<String>();
        Names.add("Johnson, Jim");
        Names.add("Jones, Aaron");
        Names.add("Jones, Chris");
        Names.add("Ling, Mai");
        Names.add("Swift, Geoffrey");
        Names.add("Xiong, Fong");
        Names.add("Zarnecki, Sabrina");

        List<String> input = test.readFile(file);
        input = test.sortArrayList(input);

        assertArrayEquals(Names.toArray(),input.toArray());
    }
}