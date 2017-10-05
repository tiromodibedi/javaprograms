import java.util.Scanner;

public class shapes{
   public static void main(String [] args){

     Scanner key = new Scanner(System.in);
     System.out.println("Enter a height:");
     int height = key.nextInt();

     for (int row = 0; row < height; row++) {
         int spaces = height - (row+1);
         int stars = row + 1;

         int stars2 = height - row;
         int spaces2 = row;

         /************************ FIRST TRIANGLE *************************/
         for (int i = 0; i < spaces; i++) {
           System.out.print(" ");
         }
         for (int j = 0; j < stars; j++) {
           System.out.print("*");
         }
         /************************ FIRST TRIANGLE *************************/

         /************************ SPACE IN BETWEEN *************************/
         System.out.print(" ");
         /************************ SPACE IN BETWEEN *************************/


         /************************ SECOND TRIANGLE *************************/
         for (int j = 0; j < stars2; j++) {
           System.out.print("*");
         }
         for (int i = 0; i < spaces2; i++) {
           System.out.print(" ");
         }
         /************************ SECOND TRIANGLE *************************/
       System.out.println();
     }

   }
}
