/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex45;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readFile() throws FileNotFoundException {
        String testResult = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\nFor example, \"She uses an IDE to write her Java programs\" instead of \"She\nutilizes an IDE to write her Java programs\".";
        App test = new App();
        File file = new File("src/test/java/ex45/exercise45_inputTest.txt");

        assertEquals(test.readFile(file),testResult);
    }

    @Test
    void replaceWord()
    {
        String testString = "the quick brown fox jumped over the lazy dog";
        String testResult = "thy quick brown fox jumped over thy lazy dog";
        App test = new App();
        assertEquals(testResult,test.replaceWord(testString,"the","thy"));
    }

    @Test
    void createFile() throws FileNotFoundException {
        App test  = new App();
        File file = new File("src/test/java/ex45/Test45.txt");
        test.createFile("src/test/java/ex45/Test45","test word");

        assertTrue(file.exists());
    }
}