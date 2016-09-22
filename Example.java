/**
* 
* Example demonstrating the use of InputList library
* 
* @author nirlendu.saha
* v1.0
*/

import java.util.*;
import java.io.IOException;

/**
*   Importing the package file
*/
import src.lib.listProcessor.InputList;

public class Example{

    /**
    *   Static string to store the input file path
    */
    private static String INPUT_FILEPATH = "InputFile/";

    /**
    *   Static strings to for the print statement
    */
    private static String INPUT_FILE = "input.txt";
    private static String IS_DUPLICATE = "Duplicate input? : ";
    private static String MOST_FREQUENT_LIST = "Most frequent list is : ";
    private static String MAX_COUNT = "Maximum number of duplicates is : ";
    private static String DUPLICATE_COUNT = "Number of duplicates is : ";
    private static String UNIQUE_COUNT = "Number of uniques is : ";
    private static String INVALID_COUNT = "Number of invalid lists is : ";
    private static String INVALID_INPUTS = "The invalid inputs are : ";

    /**
    *   Main class to initiate the example run
    */
    public static void main(String args[]){
        Example example = new Example();
        example.exampleRun();
    }

    /**
    *  Gives various inputs to the library
    */
    private void exampleRun(){

        InputList inputList = new InputList();

        //Reading the sample input file
        try{
          inputList.readFile(this.INPUT_FILEPATH + this.INPUT_FILE);
        }catch(IOException e){
          e.printStackTrace();
        }

        //Static string to load
        List<Integer> sampleList = Arrays.asList(1,2,4,3);

        //Is Sample String Dulpicate
        System.out.println(this.IS_DUPLICATE + inputList.insertNewList(sampleList));

        //Most Frequent List
        System.out.println(this.MOST_FREQUENT_LIST + inputList.getMostFrequentList());

        //Maximum count of duplicates
        System.out.println(this.MAX_COUNT + inputList.getMaxCount());
    
        //Total count of duplicates  
        System.out.println(this.DUPLICATE_COUNT + inputList.getDuplicateListCount());
        
        //Count of unique lists
        System.out.println(this.UNIQUE_COUNT + inputList.getUniqueListCount());
        
        //Count of invalid lists
        System.out.println(this.INVALID_COUNT + inputList.getInvalidListCount());
        
        //All the invalid inputs
        System.out.println(this.INVALID_INPUTS + inputList.getInvalidInput());
    }
}