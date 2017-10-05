import java.util.Scanner;

public class shapesAgain{
  public static void main(String [] args){
    Scanner key = new Scanner(System.in);
    System.out.println("Enter a height:");
    int height = key.nextInt();

    for(int row = 0; row < height; row++){
      int spaces1 = row;
      int stars = height;
      int spaces2 = height - row;

      for(int i = 0; i < spaces1; i++){
        System.out.print(" ");
      }
      for(int j = 0; j < stars; j++){
        System.out.print("*");
      }
      for(int k = 0; k < spaces2; k++){
        System.out.print(" ");
      }
      System.out.println();
    }


  }
}
