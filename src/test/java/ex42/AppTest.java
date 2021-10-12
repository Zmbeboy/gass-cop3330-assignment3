/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex42;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void parseData()
    {
        App test  = new App();
        String input = "Gass,Eric,99995";
        Employee employee = test.parseData(input);
        Employee testEmployee = new Employee();
        testEmployee.FirstName = "Eric";
        testEmployee.LastName = "Gass";
        testEmployee.salary = 99995;

        assertEquals(testEmployee.LastName,employee.LastName);
        assertEquals(testEmployee.FirstName,employee.FirstName);
        assertEquals(testEmployee.salary,employee.salary);
    }

    @Test
    void readFile() throws FileNotFoundException {
        App test = new App();
        File file = new File("src/test/java/ex42/exercise42_inputTest.txt");
        List<String> Names = new ArrayList<String>();
        Names.add("Ling,Mai,55900");
        Names.add("Johnson,Jim,56500");
        Names.add("Jones,Aaron,46000");
        Names.add("Jones,Chris,34500");
        Names.add("Swift,Geoffrey,14200");
        Names.add("Xiong,Fong,65000");
        Names.add("Zarnecki,Sabrina,51500");

        List<String> input = test.readFile(file);

        assertArrayEquals(input.toArray(),Names.toArray());
    }
}