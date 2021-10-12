/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void generateFile()
    {
        App test  = new App();
        File file = new File("src/test/java/ex43/Test43");
        test.generateFile("src/test/java/ex43/Test43");

        assertTrue(file.exists());
    }
}