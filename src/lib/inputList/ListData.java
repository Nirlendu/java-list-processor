/**
* 
* Object class for ListData
* 
* @author nirlendu.saha
* v1.0
*/

package src.lib.inputList;

import java.util.ArrayList;
import java.util.List;

public class ListData{

    /**
    *  Hash Map to store the arrays
    */
    private List<Integer> inputList = new ArrayList<Integer>();

    /**
    *  Keeps a count of the lists
    */
    private int count = 0;

    /**
    *   get the existing list
    *
    *   @return List<Integer> inputArray
    */
    public List<Integer> getInputList(){
        return this.inputList;
    }

    /**
    *   set the new list
    *
    *   @param List<Integer> inputArray
    */  
    public void setInputList(List<Integer> inputList){
        this.inputList = inputList;
    }

    /**
    *   get the count
    *
    *   @return int count
    */
    public int getCount(){
        return this.count;
    }

    /**
    *   set the count
    *
    *   @param int count
    */
    public void setCount(int count){
        this.count = count;
    }
}