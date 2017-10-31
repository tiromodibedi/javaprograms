/*********************************************************
*  Cat Class to implement the MakeSound Interface        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Question1{
  private String[] queueArray;
  private int queueSize;
  private int writePos;
  private int numberOfItems;

  public Question1(int queueSize){
    this.queueSize = queueSize;
    queueArray = new String[queueSize];
  }

  public void insert(String data){
    if (numberOfItems < queueSize) {
      if (writePos >= queueSize) {
        writePos = 0;
      }
      queueArray[writePos] = data;
      writePos++;
      numberOfItems++;
    }
  }

  public String pop(){
    if (numberOfItems == 0) {
      return "Buffer empty";
    }
    int nextSlot = writePos - numberOfItems;
    if (nextSlot < 0) {
      nextSlot += queueSize;
    }
    String nextObj = queueArray[nextSlot];
    numberOfItems--;
    return nextObj;
  }

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    String input;
    Question1 queueObject = new Question1(100);
    do {
      input = key.nextLine();
      char firstChar = input.charAt(0);

      //input = key.next(".").charAt(0);
      if (firstChar == 'O') {
        // if the first character is 'O' then Output the data from the queue
        String response = queueObject.pop();
        if (response.equals("Buffer empty")) {
          System.out.println(response);
        } else {
          System.out.println("Data: " + response);
        }
      } else {
        // if the first character is not an 'O' then save the data in the queue
        queueObject.insert(input);
      }

    } while (!(input.equals("X")));

  }
}
