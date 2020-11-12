import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	  /**
	   * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for 
	   * each row is 10 Each row in the file is separated by a new line Each element in the row is separated by a space Suggestion: 
	   * You need to know how many rows and how many columns there are for each row to create a ragged array. 
	   * 1. Read the doubles from the file into an a temporary array [10][10] of Strings which was initialized to nulls. 
	   * 2. Find out how many rows there are (any row that has the first element != null is a valid row) 
	   * 3. Create the array based on the num of rows, i.e. double[][]array = new double[#rows][] 
	   * 4. Determine the number of columns for the first row (any element != null is a valid element) 
	   * 5. Create the first row, i.e. array[0] = new double[#columns] 
	   * 6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles) 
	   * 7. Repeat for all rows.
	   * @param file the file to read from
	   * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
	   * @throws FileNotFoundException 
	   */
	  public static double[][] readFile(File file) throws FileNotFoundException  {
		  // Variables
		  Scanner scanner = new Scanner(file);
	      int indexRow = 0;
	      String[][] temp = new String[10][]; 
	    // read file and pass numbers to temp array as Strings
	    while(scanner.hasNextLine()) {
	     String[] row = scanner.nextLine().split(" ");
	     temp[indexRow] = new String[row.length];
	     for (int index = 0;index < row.length;index++) {
	       temp[indexRow][index]=row[index];   
	     }
	     indexRow++;
	    }
	   // Create double data array and parse numbers as doubles
	    double[][]data = new double[indexRow][];
	    for (int index = 0; index < indexRow;index++) {
	      data[index]= new double[temp[index].length];
	      for (int column = 0;column < temp[index].length;column++) {
	          System.out.print(temp[index][column] + " ");
	          data[index][column] = Double.parseDouble(temp[index][column]);
	      }
	      System.out.println();
	    }
	    // close scanner
	    scanner.close();
	    return data;
	  }
	
	  /**
	   * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	   * @param data two dimensional ragged array of doubles
	   * @param outputFile the file to write to
	   * @throws FileNotFoundException 
	   */
	  public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		  // Variables
		  PrintWriter fileOutput = new PrintWriter(outputFile);
		  StringBuilder stringBuilder = new StringBuilder();
		  // Loops
		  for (int index = 0;index < data.length;index++) {
			  for (int column = 0;column < data[index].length;column++) {
				  stringBuilder.append(data[index][column]+ " ");
	      }
	      stringBuilder.append("\n");
	    }
	    // Close
	    fileOutput.print(stringBuilder.toString());
	    fileOutput.close();
	  }
	
	  /**
	   * Returns the total of all the elements of the two dimensional array
	   * @param data the two dimensional array getting total of
	   * @return the sum of all the elements in the two dimensional array
	   */
	  public static double getTotal(double[][] data) {
		  // Variables
		  double total = 0;
		  // Loops
	      for (int index = 0;index < data.length;index++) { 
	    	  for (int column = 0;column < data[index].length;column++) {
	    		  total += data[index][column];
	      }
	    }
	      
	    //Return
	    return total;
	  }

  /**
   * Returns the average of the elements in the two dimensional array
   * @param data the two dimensional array getting the average of
   * @return the average of the elements in the two dimensional array (total of elements/num ofelements)
   */
  public static double getAverage(double[][] data) {
	  // Variables
    int count = 0;
    double total = 0;
    //Loops (index => Column)
    for (int index = 0;index < data.length;index++) {
    	count += data[index].length; 
      for (int column = 0;column < data[index].length; column++) {
    	  total += data[index][column];
    	  count++;
      }
    }
    return total / count;
  }
  
  /**
   * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
   * @param data the two dimensional array
   * @param row the row index to take the total of (0 refers to the first row)
   * @return the total of the row
   */
  public static double getRowTotal(double[][] data, int row) {
    // Variables
	double total = 0;
    // Loops
    for (int i = 0;i < data[row].length;i++) {
        total += data[row][i];
    }
    // Return
    return total;
  }

  /**
   * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
   * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
   * @param data the two dimensional array
   * @param col the column index to take the total of (0 refers to the first column)
   * @return the total of the column
   */
  public static double getColumnTotal(double[][] data, int col) {
    // Variables
	double total = 0;
	// Loops (index => Column[col])
    for (int index = 0;index < data.length;index++) {
    	//checks
      if (col >= data[index].length) {
        continue;
      }
      // Variables
        total += data[index][col];
    }
    // Return
    return total;
  }

  /**
   * Returns the largest element of the selected row in the two dimensional array index 0 refers tothe first row.
   * @param data the two dimensional array
   * @param row the row index to find the largest element of (0 refers to the first row)
   * @return the largest element of the row
   */
  public static double getHighestInRow(double[][] data, int row) {
	//variable
	double highest = -999999;
	//loops
    for (int index = 0;index < data[row].length;index++) {
    	//check
      if (data[row][index] > highest) { 
    	  highest = data[row][index];
      }
    }
    //Return
    return highest;
  }

  /**
   * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
   * @param data the two dimensional array
   * @param row the row index to find the largest element of (0 refers to the first row)
   * @return the largest element of the row
   */
  public static int getHighestInRowIndex(double[][] data, int row) {
   // Variables
	double highest = -999999;
    int index = -1;
    // Loops
    for (int i = 0;i < data[row].length;i++) {
    	// Check
      if (data[row][i] > highest) {
    	  highest = data[row][i];
        index = i;
      }
    }
    //Return
    return index;
  }

  /**
   * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
   * @param data the two dimensional array
   * @param row the row index to find the smallest element of (0 refers to the first row)
   * @return the smallest element of the row
   */
  public static double getLowestInRow(double[][] data, int row) {
    // Variable
	double lowest = 999999;
	// Loops
    for (int index = 0;index < data[row].length;index++) {
      if (data[row][index] < lowest) {
    	  lowest = data[row][index];
      }
    }
    //Return
    return lowest;
  }

  /**
   * Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
   * @param data the two dimensional array
   * @param row the row index to find the smallest element of (0 refers to the first row)
   * @return the index of the smallest element of the row
   */
  public static int getLowestInRowIndex(double[][] data, int row) {
    //Variables
	double lowest = 999999;
    int index = -1;
    // Loops
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] < lowest) {
    	lowest = data[row][i];
        index = i;
      }
    }
    // Return
    return index;
  }

  /**
   * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
   * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
   * @param data the two dimensional array
   * @param col the column index to find the largest element of (0 refers to the first column)
   * @return the largest element of the column
   */
  public static double getHighestInColumn(double[][] data, int col) {
    // Variables
	double highest = -999999;
	// Loops (index => Column[col]) 
    for (int index = 0;index < data.length;index++) {
    	// Checks
     if (col >= data[index].length) {
        continue;
      }
     if (data[index][col] > highest) { 
    	  highest = data[index][col];
      }
    }
    // Return
    return highest;
  }

  /**
   * Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
   * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
   * @param data the two dimensional array
   * @param col the column index to find the largest element of (0 refers to the first column)
   * @return the index of the largest element of the column
   */
  public static int getHighestInColumnIndex(double[][] data, int col) {
   // Variables
	double highest = -999999;
    int index = -1;
    // Loops
    for (int i = 0;i < data.length;i++) {
      //Checks
      if (col >= data[i].length) {continue;}
      //Checks
      if (data[i][col] > highest ) { highest = data[i][col];
        index = i;
      }
    }
    // Return
    return index;
  }

  /**
   * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
   * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
   * @param data the two dimensional array
   * @param col the column index to find the smallest element of (0 refers to the first column)
   * @return the smallest element of the column
   */
  public static double getLowestInColumn(double[][] data, int col) {
    // Variables
	double lowest = 999999;
	// Loops
    for (int index = 0;index < data.length;index++) {
    	// Checks
      if (col >= data[index].length) {
        continue;
      }
      if (data[index][col] < lowest) {
    	  lowest = data[index][col];
      }
    }
    // Return
    return lowest;
  }

  /**
   * Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column.
   * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
   * @param data the two dimensional array
   * @param col the column index to find the smallest element of (0 refers to the first column)
   * @return the index of the smallest element of the column
   */
  public static int getLowestInColumnIndex(double[][] data, int col) {
    // Variables
	double lowest = 999999;
    int index = -1;
    // Loops
    for (int i = 0;i < data.length;i++) {
    	// Checks
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] < lowest ) {
        lowest = data[i][col];
        index = i;
      }
    }
    // Return
    return index;
  }
  
  /**
   * Returns the largest element in the two dimensional array
   * @param data the two dimensional array
   * @return the largest element in the two dimensional array
   */
  public static double getHighestInArray(double[][] data) {
	// variables
    double highest = -999999;
    // Loops (index => Columns)
    for (int index = 0;index< data.length;index++) { 
      for (int column = 0;column < data[index].length;column++) {
    	  //Checks
        if (data[index][column] > highest) { highest = data[index][column];
        }
      }
    }
    return highest;
  }
 
  /**
   * Returns the smallest element in the two dimensional array
   * @param data the two dimensional array
   * @return the smallest element in the two dimensional array
   */
  public static double getLowestInArray(double[][] data) {
	// variables
	double lowest = 999999;
    for (int index = 0;index < data.length;index++) { 
      for (int column = 0;column < data[index].length;column++) {
        if (data[index][column] < lowest) {
          lowest = data[index][column];
        }
      }
    }
 // Return
    return lowest;
  }
}


