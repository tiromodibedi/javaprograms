// Arrays, linked lists, trees, etc. are best for
// data that represents real objects.

// Stacks & Queues are instead used to complete a
// task and are soon after discarded.

// Stacks & Queues
// 1. Allow only a single item to be added or removed at a time
// 2. Stacks allow access to the last item inserted (LIFO)
// 3. Queues allow access to the first item inserted (FIFO)

import java.util.Arrays;

public class Stack{
  private String[] stackArray; // stackArray to hold values in Stack
  private int stackSize; // monitor the stackSize

  // monitor top of Stack (last in first out): set the Stack as empty
  private int topOfStack = -1;

  // Constructor
  public Stack(int size){
    this.stackSize = size;
    stackArray = new String[size];
    Arrays.fill(stackArray, "-1");
  }

  // Stack methods
  public void push(String input){
    if (topOfStack + 1 < stackSize) { // check if there's enough room in Stack
      topOfStack++; // move topOfStack one level down the Stack to create space
      stackArray[topOfStack] = input; // now push an item to topOfStack
    } else {
      System.out.println("Sorry but the Stack is full");
    }
    displayTheStack();
    System.out.println("PUSH " + input + " was added to the Stack");
  }

  // remove the last item that was added to the Stack
  public String pop(){
    if (topOfStack >= 0) {
      displayTheStack();
      System.out.println("POP " + stackArray[topOfStack] + " was removed from the Stack");
      stackArray[topOfStack] = "-1";
      return stackArray[topOfStack--];
    } else {
      displayTheStack();
      System.out.println("Sorry but the Stack is empty");
      return "-1";
    }
  }

  public void pushMany(String multipleValues){
    String[] tempString = multipleValues.split(" ");
    for (int i = 0; i < tempString.length; i++) {
      push(tempString[i]);
    }
  }

  public void popAll(){
    for (int i = topOfStack; i >= 0; i--) {
      pop();
    }
  }

  public void displayTheStack(){
  			for(int n = 0; n < 61; n++)System.out.print("-");
  			System.out.println();

  			for(int n = 0; n < stackSize; n++){
  				System.out.format("| %2s "+ " ", n);
  			}
  			System.out.println("|");

  			for(int n = 0; n < 61; n++)System.out.print("-");
  			System.out.println();

  			for(int n = 0; n < stackSize; n++){
  				if(stackArray[n].equals("-1")) System.out.print("|     ");
  				else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
  			}
  			System.out.println("|");
  			for(int n = 0; n < 61; n++)System.out.print("-");
  			System.out.println();

  	}


  public static void main(String[] args) {
    Stack theStack = new Stack(10);
    theStack.push("10");
    theStack.push("7");
    theStack.push("3");
    theStack.pop();
    theStack.displayTheStack();
    theStack.pushMany("12 19 17 73");
    theStack.popAll();
    theStack.displayTheStack();
  }
}
