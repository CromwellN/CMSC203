/*Class: CMSC203 CRN 22445
 Program: Assignment 5
 Instructor: Dr. Grinberg
 Summary of Description: This program encrypt and decrypt a phrase using two similar approaches.
 Due Date: 11/15/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Cromwell Nzouakeu
*/

public class HolidayBonus {
  /**
   * Calculates the holiday bonus for each store
   * @param data the two dimensional array of store sales
   * @param high bonus for the highest store in a category
   * @param low bonus for the lowest store in a category
   * @param other bonus for all other stores in a category
   * @return an array of the bonus for each store
   */
  public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
    double[] bonuses = new double[data.length];
    //find max # of categories
    int maxCol = 0;
    for (int index = 0;index < data.length;index++) {
      if (maxCol < data[index].length) {
        maxCol = data[index].length;
      }
    }
    for (int column = 0;column < maxCol;column++) {
      // add bonus for high or low in each category
      int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, column);
      int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,column);
      // sales must be positive to get high bonus
      if (TwoDimRaggedArrayUtility.getHighestInColumn(data, column) > 0) {  
        bonuses[highBonusIndex] += high;
      }
      // sales must be positive and different from high to get low bonus
      if (TwoDimRaggedArrayUtility.getLowestInColumn(data, column) > 0 && highBonusIndex!=lowBonusIndex ) {
        bonuses[lowBonusIndex] += low;
      }
      
      // add OTHER bonus to the other stores unless not category available if sales are positive 
      for (int index = 0;index < data.length;index++) {
        if (column >= data[index].length || index==highBonusIndex || index==lowBonusIndex || data[index][column] <= 0) {
          continue;
        } else {
          bonuses[index] += other;
        } 
        System.out.println();
      }
    }   
    return bonuses;
  }

  /**
   * Calculates the total holiday bonuses
   * @param data the two dimensional array of store sales
   * @param high bonus for the highest store in a category
   * @param low bonus for the lowest store in a category
   * @param other bonus for all other stores in a category
   * @return the total of all holiday bonuses
   */
  public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
    double[] Array = HolidayBonus.calculateHolidayBonus(data, high, low, other);
    double total = 0;
    
    for (int index = 0; index < Array.length; index++) {
		total += Array[index];
	}
    return total;
  }
}

