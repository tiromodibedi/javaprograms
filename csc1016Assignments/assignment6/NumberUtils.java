/*********************************************************
*  NumberUtils Class for using static methods            *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 04-10-2017                                      *
*********************************************************/
import java.util.Arrays;

public class NumberUtils{
  // No instance variables

  // contructor
  private NumberUtils(){
    // A private empty contructor prevents the creation of a NumberUtils object
  }

  // Methods
  public static int[] toArray(int number){
    /*  Given a number that is n digits in length, maps the digits to an array
    **  ..of length n. e.g map 540 to [5, 4, 0]   */
    String numberString = String.valueOf(number);
    int[] digitsArray = new int[numberString.length()];
    for (int i = 0; i < numberString.length(); i++) {
      char c = numberString.charAt(i);
      int digit = (int) c;
      int zero = (char) '0';
      digitsArray[i] = digit - zero;
    }
    return digitsArray;
  }
  public static int countMatches(int numberA, int numberB){
    /*  given two numbers, count the quantity of matching digits - those with
    **  ..the same value and position.. example 39628 & 79324 = x9xx2x...
    **  assume the numbers are of the same length and have no repeating digits */
    int[] arrayA = toArray(numberA);
    int[] arrayB = toArray(numberB);
    int count = 0;
    for (int i = 0; i < arrayA.length; i++) {
        if (arrayA[i] == arrayB[i]) {
          count++;
        } else;
      }
    return count;
  }


  public static int countIntersect(int numberA, int numberB){
    /*  count the quantity of digits that the two numbers have in common
    **  ..regardless of position .. example 39628 & 79324 = 3, 9, 2
    **  assume the numbers are of the same length and have no repeating digits */
    int[] arrayA = toArray(numberA);
    int[] arrayB = toArray(numberB);
    int count = 0;
    for (int i = 0; i < arrayA.length; i++) {
      for (int j = 0; j < arrayB.length; j++) {
        if (arrayA[i] == arrayB[j]) {
          count++;
        } else;
      }
    }
    return count;

  }

/*
  public static void main(String[] args) {
    System.out.println("Hello, Testing");
    int[] returned = NumberUtils.toArray(3930);
    System.out.println(Arrays.toString(returned));
    System.out.println(countMatches(39628, 79324));
    System.out.println(countIntersect(39628, 79324));
  }
*/
}
