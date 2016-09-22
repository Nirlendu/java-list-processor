/**
* 
* Object class for Input Array
* 
* @author nirlendu.saha
* v1.0
*/

import java.util.*;
import java.io.*;


public class InputArray{

    /**
    *  Hash Map to store the arrays
    */
    private Map<Integer, ArrayList<ArrayData>> previousArrays = new HashMap<Integer, ArrayList<ArrayData>>();
    
    /**
    *  Count of most recurring array
    */
    private int maxCount = 0;

    /**
    *  Count of duplicate arrays
    */
    private int duplicateListCount = 0;

    /**
    *  Count of unique arrays
    */
    private int uniqueListCount = 0;

    /**
    *  Count of invalid arrays
    */
    private int invalidListCount = 0;

    /**
    *  The most frequent array
    */
    private List<Integer> mostFrequentArray = new ArrayList<Integer>();

    /**
    *  All the invalid inputs
    */
    private List<List<String>> invalidInput = new ArrayList<List<String>>();

    /**
    *  Checks for most frequent arrays
    */
    private void mostFrequent(int newCount, List<Integer> newArray){
        if(this.maxCount < newCount){
            this.maxCount = newCount;
            this.mostFrequentArray = newArray;
        }
    }

    /**
    *  Count of unique arrays
    */
    public List<Integer> getMostFrequentArray(){
        return this.mostFrequentArray;
    }

    public int getMaxCount(){
        return this.maxCount;
    }

    public int getDuplicateListCount(){
        return this.duplicateListCount;
    }

    public int getUniqueListCount(){
        return this.uniqueListCount;
    }

    public int getInvalidListCount(){
        return this.invalidListCount;
    }

    public boolean insertNewArray(List<Integer> newArray){

        //Flag to maintain if the list is duplicate
        boolean isExist = false;

        //Sorts the list for easier comparision in future. Merge Sort done  - O(n log n)
        Collections.sort(newArray);
        
        //Checks whether the key (size of the list) exists in existing Hash Map
        if(this.previousArrays.containsKey(newArray.size())){
            List<ArrayData> itemsList = previousArrays.get(newArray.size());

            //Checks for the repeated occurance of the List
            for (ArrayData eachArray : itemsList){
                if (eachArray.getInputArray().equals(newArray)){
                    eachArray.setCount(eachArray.getCount() + 1);
                    isExist = true;
                    this.duplicateListCount++;
                    this.mostFrequent(eachArray.getCount(), eachArray.getInputArray());
                    break;
                }
            }

            //List is not duplicate
            if(!isExist){
                ArrayData myItem = new ArrayData();
                myItem.setInputArray(newArray);
                myItem.setCount(1); 
                if(!itemsList.contains(myItem)) itemsList.add(myItem);
                isExist = false;
                this.uniqueListCount++;
                this.mostFrequent(myItem.getCount(), myItem.getInputArray());
            }
        }else{
            ArrayList<ArrayData> itemsList = new ArrayList<ArrayData>();
            ArrayData myItem = new ArrayData();
            myItem.setInputArray(newArray);
            myItem.setCount(1);            
            itemsList.add(myItem);
            this.previousArrays.put(newArray.size(), itemsList);
            this.uniqueListCount++;
            this.mostFrequent(myItem.getCount(), myItem.getInputArray());
        }

        return isExist;
    }



    private boolean isValid(String[] inputElements){
        for(String eachInputElement : inputElements){
            try {
                Integer.parseInt(eachInputElement.trim());
            }
            catch( Exception e ) {
                this.invalidInput.add(Arrays.asList(inputElements));
                System.out.println(this.invalidInput);
                return false;
            }
        }
        return true;
    }

    public void readFile(String fileName) throws FileNotFoundException, IOException{
        
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        //Reading the string line by line
        while ((strLine = br.readLine()) != null){
            String[] eachLineElements = strLine.split(",");

            //Checking the validity of the string
            if(!isValid(eachLineElements)){
                continue;
            }

            //Typecasting all the elements in the list from String to Integer
            Integer[] intarray = new Integer[eachLineElements.length];
            int i = 0;
            for ( String elements : eachLineElements){
                try{
                    intarray[i]=Integer.parseInt(elements.trim());
                    i++;
                }catch( Exception e ) {
                    continue;
                }
            }
            //inserting the clean List in the HashMap
            insertNewArray(Arrays.asList(intarray));
        }

        //Close the input stream
        br.close();
    }
}