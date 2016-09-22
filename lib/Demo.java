/**
* Object class for Array data
*/

import java.util.*;
import java.io.IOException;

public class Demo{

    public static void main(String args[]){
        Demo obj = new Demo();
        obj.Parse();
    }

    private void Parse(){
        List<Integer> supplierNames1 = Arrays.asList(1,2,4,3);
        List<Integer> supplierNames2 = Arrays.asList(1,2,4,5);
        List<Integer> supplierNames3 = Arrays.asList(1,4,3,2);
        //TODO - Read from file and cleanup
        Sorter sorter = new Sorter();
        sorter.insertNewArray(supplierNames1);
        sorter.insertNewArray(supplierNames2);
        sorter.insertNewArray(supplierNames3);
        try{
          sorter.readFile("input.txt");
        }catch(IOException e){
          e.printStackTrace();
        }
        System.out.println(sorter.getMostFrequentArray());
        System.out.println(sorter.getMaxCount());
    }
}