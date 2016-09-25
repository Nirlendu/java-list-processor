import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.io.IOException;

/**
*   Importing the package file
*/
import src.lib.listProcessor.InputList;

public class InputListTest {

	/**
    *   Static string to store the input file path
    */
    private static String INPUT_FILEPATH = "InputFile/";

    /**
    *   Static strings to for the print statement
    */
    private static String INPUT_FILE = "input.txt";

	/**
	 * Test method 1
	 */
	@Test
	private void runTest1(){
		InputList inputList = new InputList();

        //Reading the sample input file not writing much test cases as most of the test cases are covered here itself
        try{
          inputList.readFile(this.INPUT_FILEPATH + this.INPUT_FILE);
        }catch(IOException e){
          e.printStackTrace();
        }
        assertEquals(Arrays.asList(3, 5, 11, 23, 24, 88, 189), inputList.getMostFrequentList());
        assertEquals(29, inputList.getMaxCount());
        assertEquals(475, inputList.getDuplicateListCount());
        assertEquals(27, inputList.getUniqueListCount());
        assertEquals(6, inputList.getInvalidListCount());
        assertEquals(Arrays.asList("[,,,,]", "[A, B, C]", "[---]", "[This line should be ignored because it's not valid]", "[,]", "[50 41 87 95]"), inputList.getInvalidInput());
	}

	/**
	 * Test method 2
	 */
	@Test
	private void runTest2(){
		InputList inputList = new InputList();

        //Inserting Sample List
        String sampleList = "1,2,4,3";

        assertEquals(false, inputList.insertNewString(sampleList));
        assertEquals(Arrays.asList(1, 2, 3 , 4), inputList.getMostFrequentList());
        assertEquals(1, inputList.getMaxCount());
        assertEquals(0, inputList.getDuplicateListCount());
        assertEquals(1, inputList.getUniqueListCount());
        assertEquals(0, inputList.getInvalidListCount());
        assertEquals(Arrays.asList(""), inputList.getInvalidInput());
	}

}