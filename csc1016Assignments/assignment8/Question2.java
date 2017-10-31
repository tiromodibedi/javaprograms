import java.util.Scanner;
import java.util.Arrays;

public class Question2{
  private char[] stackArray;
  private int stackSize;
  private int topOfStack;

  public Question2(int size){
    this.stackSize = size;
    stackArray = new char[size];
    topOfStack = -1;
  }

  public void push(char c){
    topOfStack++;
    stackArray[topOfStack] = c;
  }

  public char pop (){
    //--topOfStack;
    return stackArray[topOfStack--];
  }

  public char peek(){
    return stackArray[topOfStack];
  }

  public boolean isEmpty(){
    return (topOfStack == -1);
  }

  public static String StringCheck(String str){
    String result = "The string is correct! There are no mismatched brackets.";
    int stackSize = str.length();
    Question2 myStack = new Question2(stackSize);
    char chx, chy;

    for (int i = 0; i < str.length(); i++) {
      chy = str.charAt(i);
      if ((chy == '(') || (chy == '[') || (chy == '{') || (chy == '<')) {
        myStack.push(chy);
      }
      else if ((chy == ')') || (chy == ']') || (chy == '}') || (chy == '>')) {
        if (!myStack.isEmpty()) {
          chx = myStack.peek();
          if ((chy == ')' && chx == '(') ||
              (chy == ']' && chx == '[') ||
              (chy == '}' && chx == '{') ||
              (chy == '>' && chx == '<')
              ) {
            myStack.pop();
          } else {
            result = "error: " + "'" + chy + "'" + " does not match with " + "'" + chx + "'";
          }
        }
      }
    }
    if (!myStack.isEmpty()) {
      return "let's see what this does!";
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Enter a string to test:");
    String inputText = key.nextLine();
    //Question2 queueObject = new Question2(100);
    System.out.println(StringCheck(inputText));
  }
}





/*
switch (cy) {
  case '{':
  case '[':
  case '(':
  case '<':
    myStack.push(cy);
    break;

  case '}':
  case ']':
  case ')':
  case '>':
    if (!myStack.isEmpty()) {
      char cx = myStack.pop();
      if ((cy == '}' && cx != '{') ||
          (cy == ']' && cx != '[') ||
          (cy == ')' && cx != '(') ||
          (cy == '>' && cx != '<')
          ){
            System.out.println("error: " + "'" + cy + "'" + " does not match with " + "'" + cx + "'");
          } else {
            System.out.println("The string is correct! There are no mismatched brackets.");
            //System.out.println("Error: " + cy + " at " + i);
          }
    }
    break;
}
//break;
}
if (myStack.isEmpty()) {
System.out.println("Error: missing right delimiter");
}
*/
