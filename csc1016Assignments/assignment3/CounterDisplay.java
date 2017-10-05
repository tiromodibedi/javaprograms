/*********************************************************
*  CounterDisplay class for advancing Time               *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 03-09-2017                                      *
*********************************************************/
public class CounterDisplay{
  // instance variables
  private int limit;
  private int value;

  // constructors
  public CounterDisplay(int pLimit){
    value = 0;
    limit = pLimit - 1;
  }

  // methods
  public void setValue(int pValue){
    value = pValue;
  }

  public int getValue(){
    return value;
  }
  public void increment(){
    // advance the value by one
    if (value < limit) {
      value++;
    } else if (value == limit){
      value = 0;
    } else;
  }

  public String getDisplayValue(){
    return (""+(100+value)).substring(1);
  }

  /*
  // main method to test it out
  public static void main(String[] args) {
    CounterDisplay counterDisplay = new CounterDisplay(60);
    for (int i = 0; i < 70; i++) {
      counterDisplay.increment();
      System.out.println(counterDisplay.getDisplayValue());
    }
  } */
}
