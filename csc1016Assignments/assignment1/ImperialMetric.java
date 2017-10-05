/*********************************************************
*  Imperial Metric Program   *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-08-2017                                      *
*********************************************************/

// import the Scanner class and make it available for our project
import java.util.Scanner;

public class ImperialMetric{
  public static void main(String [] args){
    // creates a scanner object
    Scanner keyboard = new Scanner(System.in);

    int feet, inches;
    double meters;

    //prompt user input
    System.out.println("Enter the minimum number of feet (not less than 0):");
    int min = keyboard.nextInt();
    System.out.println("Enter the maximum number of feet (not more than 30):");
    int max = keyboard.nextInt();

    for (feet = min - 1; feet <= max ; feet ++ ) {
      if (feet < min) {
        System.out.printf("%4s","|");
      }
      else {
        System.out.print(feet);
        if (feet <= 9 && feet >= 0) {
          System.out.printf("%-2s%1s", "'","|");
        } else {
          System.out.printf("%s%1s", "'","|");
        }
      }
      for (inches = 0; inches <= 11; inches++) {
        if (feet < min) {
          System.out.printf("%5d%s",inches,"\"");
        }
        else {
          meters = (feet*12 + inches)*0.0254;
          System.out.printf("%6.3f",meters);
        }
        //System.out.println(feet);
      }
      System.out.printf("%n");
    }





  }
}
