/*********************************************************
*  A TestCollator Program to test the Collator Program   *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 27-08-2017                                      *
*********************************************************/

public class TestCollator{
  public static void main(String[] args) {

    // Test 1
    System.out.println("Test 1");
    Collator collator = new Collator("");
    if (collator.label().equals("")) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    // Test 2: crete a new collator object --> change label --> test
    System.out.println("Test 2");
    collator = new Collator("");
    if (collator.label().equals("")
      && collator.numberOfReadings() == 0
      && collator.maximum() == 0
      && collator.minimum() == 0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

    // Test 3
    System.out.println("Test 3");
    collator = new Collator("");
    collator.label("hungry");
    if (collator.label().equals("hungr")) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

    // Test 4
    System.out.println("Test 4");
    collator = new Collator("");
    collator.label("prime");
    collator.recordReading(5);
    if (collator.label().equals("prime")
      && collator.numberOfReadings() == 1
      && collator.maximum() == 5
      && collator.minimum() == 5
      && collator.average() == 5.0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

    // Test 5
    System.out.println("Test 5");
    collator = new Collator("");
    collator.recordReading(1);
    if (collator.label().equals("")
      && collator.numberOfReadings() == 1
      && collator.maximum() == 1
      && collator.minimum() == 1
      && collator.average() == 1.0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

    // Test 6
    System.out.println("Test 6");
    collator = new Collator("");
    collator.recordReading(0);
    if (collator.label().equals("")
      && collator.numberOfReadings() == 1
      && collator.maximum() == 0
      && collator.minimum() == 0
      && collator.average() == 0.0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

    // Test 7
    System.out.println("Test 7");
    collator = new Collator("");
    collator.recordReading(-1);
    if (collator.label().equals("")
      && collator.numberOfReadings() == 1
      && collator.maximum() == -1
      && collator.minimum() == -1
      && collator.average() == -1.0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }
/*
    // Blueprint
    System.out.println("Test 5");
    collator = new Collator("");
    collator.recordReading(1);
    System.out.println(collator.numberOfReadings());
    System.out.println(collator.maximum());
    System.out.println(collator.minimum());
    System.out.println(collator.average());
    if (collator.label().equals("")
      && collator.numberOfReadings() == 1
      && collator.maximum() == 1
      && collator.minimum() == 1
      && collator.average() == 1.0
      ) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }
*/

  }
}
