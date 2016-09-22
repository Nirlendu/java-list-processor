/*
Object class for Array data
*/

import java.util.ArrayList;
import java.util.List;

public class ArrayData{
    private List<Integer> inputArray = new ArrayList<Integer>();
    private int count = 0;

    public List<Integer> getInputArray(){
        return this.inputArray;
    }

    public void setInputArray(List<Integer> inputArray){
        this.inputArray = inputArray;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count){
        this.count = count;
    }
}