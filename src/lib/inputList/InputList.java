/**
* 
* Input List
* 
* @author nirlendu.saha
* v1.0
*/

package src.lib.inputList;

import java.util.*;
import java.io.*;


public class InputList{

    /**
    *  Hash Map to store the lists
    */
    private Map<Integer, ArrayList<ListData>> previousLists = new HashMap<Integer, ArrayList<ListData>>();
    
    /**
    *  Count of most recurring list
    */
    private int maxCount = 0;

    /**
    *  Count of duplicate list
    */
    private int duplicateListCount = 0;

    /**
    *  Count of unique list
    */
    private int uniqueListCount = 0;

    /**
    *  Count of invalid list
    */
    private int invalidListCount = 0;

    /**
    *  The most frequent list
    */
    private List<Integer> mostFrequentList = new ArrayList<Integer>();

    /**
    *  All the invalid inputs
    */
    private List<List<String>> invalidInput = new ArrayList<List<String>>();

    /**
    *   Checks for most frequent list
    *
    *   @param int NewCount, List<Integer> newList
    */
    private void mostFrequent(int newCount, List<Integer> newList){
        if(this.maxCount < newCount){
            this.maxCount = newCount;
            this.mostFrequentList = newList;
        }
    }

    /**
    *   The most frequent list
    *
    *   @return List<Integer> mostFrequentList
    */
    public List<Integer> getMostFrequentList(){
        return this.mostFrequentList;
    }

    /**
    *   Count of most recurring list
    *
    *   @return int maxCount
    */
    public int getMaxCount(){
        return this.maxCount;
    }

    /**
    *   Count of duplicating lists
    *
    *   @return int duplicateListCount
    */
    public int getDuplicateListCount(){
        return this.duplicateListCount;
    }

    /**
    *   Count of unique lists
    *
    *   @return int uniqueListCount
    */
    public int getUniqueListCount(){
        return this.uniqueListCount;
    }

    /**
    *   Count of invalid lists
    *
    *   @return int invalidListCount
    */
    public int getInvalidListCount(){
        return this.invalidListCount;
    }

    /**
    *   Insert a new List
    *
    *   @param List<Integer> newList
    *   @return bool
    */
    public boolean insertNewList(List<Integer> newList){

        //Flag to maintain if the list is duplicate
        boolean isExist = false;

        //Sorts the list for easier comparision in future. Merge Sort done  - O(n log n)
        Collections.sort(newList);
        
        //Checks whether the key (size of the list) exists in existing Hash Map
        if(this.previousLists.containsKey(newList.size())){
            List<ListData> itemsList = previousLists.get(newList.size());

            //Checks for the repeated occurance of the List
            for (ListData eachList : itemsList){
                if (eachList.getInputList().equals(newList)){
                    eachList.setCount(eachList.getCount() + 1);
                    isExist = true;
                    this.duplicateListCount++;
                    this.mostFrequent(eachList.getCount(), eachList.getInputList());
                    break;
                }
            }

            //List is not duplicate
            if(!isExist){
                ListData myItem = new ListData();
                myItem.setInputList(newList);
                myItem.setCount(1); 
                if(!itemsList.contains(myItem)) itemsList.add(myItem);
                isExist = false;
                this.uniqueListCount++;
                this.mostFrequent(myItem.getCount(), myItem.getInputList());
            }
        }else{
            ArrayList<ListData> itemsList = new ArrayList<ListData>();
            ListData myItem = new ListData();
            myItem.setInputList(newList);
            myItem.setCount(1);            
            itemsList.add(myItem);
            this.previousLists.put(newList.size(), itemsList);
            this.uniqueListCount++;
            this.mostFrequent(myItem.getCount(), myItem.getInputList());
        }

        return isExist;
    }

    /**
    *   Checks for the validity of a new List
    *
    *   @param String[] inputElements
    *   @return bool
    */    
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

    /**
    *   Read a file for sample input
    *
    *   @param String fileName
    */
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
            insertNewList(Arrays.asList(intarray));
        }

        //Close the input stream
        br.close();
    }
}