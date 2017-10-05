/*********************************************************
*  Palindrome perfect squares Program                    *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-08-2017                                      *
*********************************************************/

import java.util.Scanner;

public class PalinPerfect{

  public static void main(String[] args) {
    // create a scanner object named keyboard
    Scanner keyboard = new Scanner(System.in);

    // prompt user input
    System.out.println("Enter the starting point N:");
    int start =  keyboard.nextInt();
    System.out.println("Enter the ending point M:");
    int end = keyboard.nextInt();

    System.out.println("The palindromic perfect squares are as follows:");
    for (int n = start; n <= end; n++) {
      double sq = Math.sqrt(n);
      int x = (int) sq;
      if (Math.pow(sq, 2) == Math.pow(x,2) && n != 0 && start != end) {
        String s = Integer.toString(n);
        if (s.equals(intStrRev(n))) {
          System.out.println(n);
        }
      } else;

    }
  }

  public static String intStrRev(int num){
    String str = Integer.toString(num);
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();

    return sb.toString();
  }
}
