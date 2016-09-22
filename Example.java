/**
* 
* Example demonstrating the use of InputList library
* 
* @author nirlendu.saha
* v1.0
*/

import java.util.*;
import java.io.IOException;
import src.lib.inputList.InputList;

public class Example{

    public static void main(String args[]){
        Example example = new Example();
        example.exampleRun();
    }

    private void exampleRun(){
        List<Integer> supplierNames1 = Arrays.asList(1,2,4,3);
        List<Integer> supplierNames2 = Arrays.asList(1,2,4,5);
        List<Integer> supplierNames3 = Arrays.asList(1,4,3,2);
        //TODO - Read from file and cleanup
        InputList inputList = new InputList();
        // inputList.insertNewlist(supplierNames1);
        // inputList.insertNewList(supplierNames2);
        // inputList.insertNewList(supplierNames3);
        //System.out.println(inputList.insertNewlist(supplierNames1));
        try{
          inputList.readFile("exampleInputFile/input.txt");
        }catch(IOException e){
          e.printStackTrace();
        }
        System.out.println(inputList.getMostFrequentList());
        System.out.println(inputList.getMaxCount());
    }
}