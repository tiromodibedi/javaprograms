/*********************************************************
*  Driver Class For Q1, assignment 7                     *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Question1{
  public static void main(String[] args) {

    ArrayList<SoftDrink> items = new ArrayList<SoftDrink>();

    Scanner key = new Scanner(System.in); // scanner object

    int selection;  // selection variable

    do {
      System.out.println("Enter option: (1) add soft drink (2) quit:");
      selection = key.nextInt();

      if (selection == 1) {

        System.out.println("Enter name, colour and volume in ml separated by space");
        key.nextLine();
        String input = key.nextLine();
        String[] inputArray = input.split("\\s");

        String name = inputArray[0];
        String colour = inputArray[1];
        int volume = Integer.parseInt(inputArray[2]);

        SoftDrink softDrink = new SoftDrink(name, colour, volume);
        items.add(softDrink);
      } else {
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
          System.out.println(items.get(i).toString());
        }
      }
    } while (selection != 2);
  }
}
